package Chat.Main;

import intercode.Main;

import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Group {

	private String password;
	private String name;
	private HashMap<String,Client> clients;
	private int size = Main.SIZE;

	public Group(String name, String password){
		clients = new HashMap<String, Client>();
		this.name = name;
		this.password = password;
	}

	public boolean is_ready(){
		return true;
	}

	public void add_client(String name, ObjectOutputStream objectOutputStream){
		System.out.println("added client"+name);
		clients.put(name, new Client(name,objectOutputStream));
	}

	public boolean remove_client(String name){
		if (client_exist(name)) {
			clients.remove(name);
			return true;
		}
		return false;
	}

	public boolean remove_all(String name){
		boolean flag = true;
		Iterator client = clients.entrySet().iterator();
		while (client.hasNext()){
			Map.Entry g = (Map.Entry)client.next();
			flag = flag & this.remove_client(((Client)g.getValue()).getName());
		}

		return flag;
	}

	public boolean client_exist(String name){
		return clients.containsKey(name);
	}

	public boolean send_message(Object message){

		boolean flag = true;
		Iterator client = clients.entrySet().iterator();
		while (client.hasNext()){
			Map.Entry g = (Map.Entry)client.next();
			flag = flag & ((Client)g.getValue()).send_message(message);
		}

		return flag;
	}

	public boolean send_message(Object message, String clientName){
		if (client_exist(clientName)){
			return clients.get(clientName).send_message(message);
		}
		return false;
	}

}






