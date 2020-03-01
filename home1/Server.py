#!/usr/bin/env python3

import socket
import select
import sys
import threading

server = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
server.setsockopt(socket.SOL_SOCKET, socket.SO_REUSEADDR, 1) 
if(len(sys.argv) != 2):
    print("Put <port number> as an argument!")
    exit()

IP_ADDR = '127.0.0.1'
PORT = int(sys.argv[1])
MAX_CLIENTS = 100

server.bind((IP_ADDR,PORT))
server.listen(MAX_CLIENTS)

#list of client sockets
clients = []
clients_name = []

def client_connection_thread(con_socket, address, name):
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
        clients.remove(con_socket)

while True:
    conn, addr = server.accept()
    clients.append(conn)
    name = conn.recv(1024).decode()
    clients_name.insert(clients.index(conn), name)
    print("Starting thread for "+name)
    threading.Thread(target=client_connection_thread, args=(conn,addr,name)).start()

conn.close()
server.close()