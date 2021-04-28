### Mutual-TSL-Client-Server

# ==== client side application prepardness ===
## Keystore for client 
``` keytool -genkeypair -alias client -keyalg RSA -keysize 2048 -storetype JKS -keystore client.jks -validity 3650 -ext SAN=dns:localhost,ip:127.0.0.1 ```
### password for client store :: clientpassword

## Generate client certificate to add it into server jks to eastablish the trust relationship

### Create public certificate for client 
``` keytool -export -alias client -file client.crt -keystore client.jks ```

## Import Server Cert to client jks File:
``` keytool -import -alias server -file server.crt -keystore client.jks ```
### pass : clientpassword

# === server side application prepardness ====
## Keystore for client 
``` keytool -genkeypair -alias server -keyalg RSA -keysize 2048 -storetype JKS -keystore server.jks -validity 3650 -ext SAN=dns:localhost,ip:127.0.0.1 ```
### password for server store : serverpassword


## public certificate for server 
``` keytool -export -alias server -file server.crt -keystore server.jks ```


## Import Client Cert to server jks File:
``` keytool -import -alias client -file client.crt -keystore server.jks ```
### password of server jks store : serverpassword


# === To invoke client from browser certificate ===

## Add truted certificate of sever pk12 into browser to eastablish trust between browser and client application

``` keytool -importkeystore -srckeystore server.jks -destkeystore server.p12 -srcstoretype JKS -deststoretype PKCS12 -srcstorepass serverpassword -deststorepass serverpassword -srcalias server -destalias server -srckeypass serverpassword -destkeypass serverpassword -noprompt ```
