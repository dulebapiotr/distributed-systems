#!/usr/bin/env python3

import socket
import select
import sys
import threading

server = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
server.setsockopt(socket.SOL_SOCKET, socket.SO_REUSEADDR, 1) 
udp_socket = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)

if(len(sys.argv) != 2):
    print("Put <port number> as an argument!")
    exit()

IP_ADDR = '127.0.0.1'
PORT = int(sys.argv[1])
MAX_CLIENTS = 100

udp_socket.bind((IP_ADDR,PORT))
server.bind((IP_ADDR,PORT))

server.listen(MAX_CLIENTS)

#list of client sockets
clients = []
clients_address=[]
clients_name = []


def client_connection_thread(con_socket, name):
    con_socket.send("Welcome to chat!".encode())
    while True:
        try:
            message = con_socket.recv(1024).decode()
            if message:
                print("Received message "+message)
                message_to_send = "<"+name+"> "+message
                broadcast(message_to_send, con_socket)
            else:
                remove(con_socket)    
        except:
            continue
        

def broadcast(message, con_socket):
    for client in clients:
        if client != con_socket:
            try:
                print("Sending message "+message)
                client.send(message.encode())
            except:
                client.close()
                remove(client)
           
def remove(con_socket):
    if con_socket in clients:
        del clients[clients.index(con_socket)]
        del clients_address[clients.index(con_socket)]
        clients.remove(con_socket)

def udp_receive_thread(udp_sck):
    while True:
        try:
            buff, address = udp_sck.recvfrom(1024)
            print("Received udp: "+str(buff,'utf-8')+" from "+str(address))
            for adr in clients_address:
                if adr != address:
                    udp_sck.sendto(buff, (adr) )
        except:
            continue

        
print("udp adr: "+str(udp_socket.getsockname()))
print("tcp adr: "+str(server.getsockname()))
threading.Thread(target=udp_receive_thread, args=((udp_socket,))).start()
while True:
    conn, addr = server.accept()
    clients_address.append(addr)
    clients.append(conn)
    name = conn.recv(1024).decode()
    clients_name.insert(clients.index(conn), name)
    print("Starting thread for "+name)
    print(name +" adr: "+ str(addr))
    threading.Thread(target=client_connection_thread, args=(conn,name)).start()

conn.close()
server.close()