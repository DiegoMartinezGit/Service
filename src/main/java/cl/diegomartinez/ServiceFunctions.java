package cl.diegomartinez;

import cl.vicenterivera.SOAServiceLib.Functional;
import cl.vicenterivera.SOAServiceLib.ServiceFunction;
import cl.vicenterivera.SOALib.JsonMapper;
import cl.vicenterivera.SOAServiceLib.Functional;
import cl.vicenterivera.SOAServiceLib.ServiceFunction;
import cl.vicenterivera.SOAServiceLib.exception.FunctionExecutionException;
import cl.diegomartinez.db.dao.ChatDao;
import cl.diegomartinez.db.model.Chat;
import com.fasterxml.jackson.core.type.TypeReference;

import java.sql.Timestamp;
import java.util.*;

public class ServiceFunctions implements Functional {
    @ServiceFunction(name = "get_user")
    public String getUser(String[] args) {
        return "Hola mundo chat!";

    }

    @ServiceFunction(name = "send_message")
    public String generatechat(Map<String, Object> params) {
        Chat chat = new Chat();

        chat.setId_usr1(Integer.toUnsignedLong((Integer) params.get("id_usr1")));
        chat.setMsj(String.valueOf(params.get("content")));
        chat.setId_usr2(Integer.toUnsignedLong((Integer) params.get("id_usr2")));
        chat.setTimestamp(new Timestamp(System.currentTimeMillis()));
        ChatDao.save(chat);

        return "chaat_generado";
    }

    @ServiceFunction(name = "get_messages")
    public String get_chat(String[] args){
        Long id;
        id = Long.parseLong("1");
        return JsonMapper.asJsonString(ChatDao.msjs_byid(id));
    }

}





