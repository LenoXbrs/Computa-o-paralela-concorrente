package av3questao3;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

    public static void main(String[] args) {
        int portNumber = 8086;

        try (ServerSocket serverSocket = new ServerSocket(portNumber)) {
            System.out.println("Servidor de Coleta de Dados iniciado na porta " + portNumber);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                Thread clientThread = new Thread(new SensoresClienteHandler(clientSocket), "ClienteThread");

                clientThread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

