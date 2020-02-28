#!/usr/bin/env python3

import socket
import sys
import select

server = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
if len(sys.argv) != 3:
    print("Put <port number> and <client name> as an arguments!")
    exit()
IP_ADDR = '127.0.0.1'
PORT = int(sys.argv[1])
NAME = str(sys.argv[2])
server.connect((IP_ADDR,PORT))
server.send(NAME.encode())
print("Hello "+NAME)
print("Connection has been established successfully!")

while True:
    read_list=[server, sys.stdin]
    read_ready, write_ready, err = select.select(read_list,[],[])
    for source in read_ready:
        if source == server:
            message = server.recv(1024)
            print(message.decode())
        else:
            message = sys.stdin.readline()
            server.send(message.encode())
            print("<"+NAME+"> " + message.replace('\n', ' ').replace('\r', '')) 

server.close()