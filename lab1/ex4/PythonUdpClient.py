import socket;

serverIP = "127.0.0.1"
serverPort = 9011
msg = "p"

print('PYTHON UDP CLIENT')
client = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)

client.sendto(msg, (serverIP, serverPort))

while True:
    buff, address = client.recvfrom(1024)
    print("received msg: " + str(buff))
