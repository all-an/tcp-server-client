<p align="center">
  <a href="" target="blank"><img src="/tcp-logo.png" width="320" alt="Logo" /></a>
</p>
## javac :

> javac Client.java

```bash
\quit to quit the client side
```


## Installation

```bash
$ Run the Server on Intellij than run the Clients in multiple cmd or terminal
```

## Client run

```java
public void run() {
        try {
            client = new Socket("127.0.0.1", 9999);
            out = new PrintWriter(client.getOutputStream(),true);
            in = new BufferedReader(new InputStreamReader(client.getInputStream()));

            InputHandler inputHandler = new InputHandler();
            Thread t = new Thread(inputHandler);
            t.start();

            String inputMessage;
            while((inputMessage = in.readLine()) != null){
                System.out.println(inputMessage);
            }

        } catch (IOException e) {
            //TODO handle
        }

    }
```

## Server run 

```java
public void run(){
            try{
                out = new PrintWriter(client.getOutputStream(), true);
                in = new BufferedReader(new InputStreamReader(client.getInputStream()));
                out.println("Please enter a nickname: ");
                nickname = in.readLine();
                System.out.println(nickname + " connected !");
                broadcast(nickname + "joined the chat!");
                String message;
                while ((message = in.readLine()) != null ){
                    if(message.startsWith("/nick")){
                        String[] messageSplit = message.split( " ", 2);
                        if(messageSplit.length == 2){
                            broadcast(nickname + " renamed themselves to " + messageSplit[1]);
                            System.out.println(nickname + " renamed themselves to " + messageSplit[1]);
                            nickname = messageSplit[1];
                            out.println("Successfully changed nickname to " + nickname);
                        } else {
                            out.println("No nickname provided!");
                        }
                    } else if (message.startsWith("/quit")) {
                        broadcast(nickname + " left the chat!");
                        shutdown();
                    } else {
                        broadcast(nickname + ": " + message);
                    }
                }
            }catch(IOException e){
                shutdown();
            }
        }
```


## License

Nest is [MIT licensed](LICENSE).
