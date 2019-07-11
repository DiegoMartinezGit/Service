package cl.diegomartinez;

import cl.diegomartinez.db.model.Chat;
import cl.vicenterivera.SOAServiceLib.HibernateUtil;
import cl.vicenterivera.SOAServiceLib.SoaService;
import cl.diegomartinez.db.dao.ChatDao;
import java.sql.Timestamp;


    public class Service extends SoaService {

        public Service(String address, int busPort, int localPort, String name) {
            super(address, busPort, localPort, name);
            registerFunctions(new ServiceFunctions());

        }

        public static void main(String[] args) {
            Service service = new Service("127.0.0.1", 1025, 2000, "juCha");

            HibernateUtil.loadClasses(Chat.class);

            HibernateUtil.getSessionFactory();

            generatemessages();

            service.init();
        }

        private static void generatemessages() {
            Chat chat = new Chat();
            chat.setMsj("HOlaHOla HOLAHOLA");
            chat.setId_usr1(1L);
            chat.setId_usr2(2L);
            chat.setTimestamp(new Timestamp(System.currentTimeMillis()));
            ChatDao.save(chat);

            chat = new Chat();
            chat.setMsj("holadevueltaxdxd");
            chat.setId_usr1(2L);
            chat.setId_usr2(1L);
            chat.setTimestamp(new Timestamp(System.currentTimeMillis()));
            ChatDao.save(chat);

            chat = new Chat();
            chat.setMsj("tu family?");
            chat.setId_usr1(1L);
            chat.setId_usr2(2L);
            chat.setTimestamp(new Timestamp(System.currentTimeMillis()));
            ChatDao.save(chat);
            chat = new Chat();
            chat.setMsj("???");
            chat.setId_usr1(1L);
            chat.setId_usr2(2L);
            chat.setTimestamp(new Timestamp(System.currentTimeMillis()));
            ChatDao.save(chat);
            chat = new Chat();
            chat.setMsj("xdxdxd?");
            chat.setId_usr1(1L);
            chat.setId_usr2(2L);
            chat.setTimestamp(new Timestamp(System.currentTimeMillis()));
            ChatDao.save(chat);
            chat = new Chat();
            chat.setMsj("nosequewa");
            chat.setId_usr1(1L);
            chat.setId_usr2(2L);
            chat.setTimestamp(new Timestamp(System.currentTimeMillis()));
            ChatDao.save(chat);
            chat = new Chat();
            chat.setMsj("jiji xd");
            chat.setId_usr1(1L);
            chat.setId_usr2(3L);
            chat.setTimestamp(new Timestamp(System.currentTimeMillis()));
            ChatDao.save(chat);


        }
    }






