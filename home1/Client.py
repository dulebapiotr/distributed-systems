#!/usr/bin/env python3

import socket
import sys
import select
import threading

def udp_receive_thread(udp_sck):
    while True:
        try:
            buff, address = udp_sck.recvfrom(1024)
            print(str(buff,'utf-8'))

        except:
            continue

tcp_client = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
udp_socket = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)

if len(sys.argv) != 3:
    print("Put <port number> and <client name> as an arguments!")
    exit()

IP_ADDR = '127.0.0.1'
PORT = int(sys.argv[1])
NAME = str(sys.argv[2])
print("Hello "+NAME)

tcp_client.connect((IP_ADDR,PORT))
#We want to have the same address and port while using TCP and UDP
udp_socket.bind((tcp_client.getsockname()))
tcp_client.send(NAME.encode())
print("TCP works, address: "+ str(tcp_client.getsockname()))

threading.Thread(target=udp_receive_thread, args=((udp_socket,))).start()

while True:
    read_list=[tcp_client, sys.stdin]
    read_ready, write_ready, err = select.select(read_list,[],[])
    for source in read_ready:
        if source == tcp_client:
            message = tcp_client.recv(1024)
            print(message.decode())
        elif source == sys.stdin:
            message = sys.stdin.readline()
            if message[0]== 'U':
                udp_socket.sendto(bytes("<"+NAME+">"+ message[1:],'utf-8'),(IP_ADDR,PORT)) 
            else:
                tcp_client.send(message.encode())
                print("<"+NAME+"> " + message.replace('\n', ' ').replace('\r', ''))
        

tcp_client.close()