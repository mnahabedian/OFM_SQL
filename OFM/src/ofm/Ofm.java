/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ofm;

import java.util.Date;
import java.util.List;
import javafx.application.Application;
import javafx.stage.Stage;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import ofm.model.daos.DataDAO;
import ofm.model.daos.DataEventDAO;
import ofm.model.daos.DataGraphicDAO;
import ofm.model.daos.DeviceDAO;
import ofm.model.daos.LimitDAO;
import ofm.model.daos.OccurrenceDAO;
import ofm.model.daos.ParameterDAO;
import ofm.model.daos.UserDAO;
import ofm.model.daos.exceptions.IllegalOrphanException;
import ofm.model.daos.exceptions.NonexistentEntityException;
import ofm.model.entities.Data;
import ofm.model.entities.DataEvent;
import ofm.model.entities.DataGraphic;
import ofm.model.entities.Device;
import ofm.model.entities.Limit;
import ofm.model.entities.Occurrence;
import ofm.model.entities.Parameter;
import ofm.model.entities.User;

/**
 *
 * @author joshua
 */
public class Ofm extends Application {
    
    private EntityManagerFactory emf;
    
    @Override
    public void start(Stage primaryStage) throws IllegalOrphanException, NonexistentEntityException, Exception {
        emf = Persistence.createEntityManagerFactory("ofmPU");
        
        UserDAO userDao = new UserDAO(emf);
        DeviceDAO deviceDao = new DeviceDAO(emf);
        ParameterDAO parameterDao = new ParameterDAO(emf);
        LimitDAO limitDao = new LimitDAO(emf);
        DataDAO dataDao = new DataDAO(emf);
        DataGraphicDAO dataGraphicDao = new DataGraphicDAO(emf);
        DataEventDAO dataEventDao = new DataEventDAO(emf);
        OccurrenceDAO occurrenceDao = new OccurrenceDAO(emf);
        
        User user = userDao.findUser(1);
        if (user == null) {
            System.out.println("Incluindo Usuário...");
            
            user = new User();
            user.setUsername("admin");
            user.setEmail("teste@vai.dar.certo");
            user.setPassword("13");
            user.setCreateTime(new Date());
            userDao.create(user);
        }
        System.out.println(user.toString());

        Device device = deviceDao.findDevice(1);
        if (device == null) {
            System.out.println("Incluindo Device...");

            device = new Device();
            device.setName("DEVICE_1");
            device.setIp("123");
            device.setMask("1");
            device.setGateway("2");
            device.setUser(user);
            device.setCreateTime(new Date());
            device.setStatus("Active");
            deviceDao.create(device);

            Parameter parameter = new Parameter(0, 0, 0, 0, 0, new Float(0), new Float(0), new Float(0), new Float(0), 0, 0, 0, 0, new Date());
            parameter.setDevice(device); // enlace bidirecional
            parameter.setUser(user);
            parameterDao.create(parameter);
            device.setParameter(parameter); // enlace bidirecional

            Limit limit = new Limit(new Float(0), new Float(0), new Float(0), new Float(0), new Float(0), new Float(0), new Float(0), new Float(0), new Float(0), new Float(0), new Date());
            limit.setDevice(device); // enlace bidirecional
            limit.setUser(user);
            limitDao.create(limit);
            device.setLimit(limit); //enlace bidirecional

            Data data = new Data(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
            data.setDevice(device); //enlace bidirecional
            dataDao.create(data);
            device.setData(data); //enlace bidirecional
            
            for(int i = 0; i < 100; i++) {
                DataGraphic dataGraphic = new DataGraphic(data, i); //enlace bidirecional
                dataGraphicDao.create(dataGraphic);
                data.getDataGraphicList().add(dataGraphic); //enlace bidirecional
            }
            
            for(int i = 0; i < 5; i++) {
                DataEvent dataEvent = new DataEvent(new Float(0), 0, new Float(0), new Float(0), new Float(0), new Float(0));
                dataEvent.setData(data); //enlace bidirecional
                dataEventDao.create(dataEvent);
                data.getDataEventList().add(dataEvent); //enlace bidirecional
            }
            
            Occurrence occurrence = new Occurrence("Red", "Fibra Quebrada", new Date());
            occurrence.setDevice(device); //enlace bidirecional
            occurrenceDao.create(occurrence);
            device.getOccurrenceList().add(occurrence); //enlace bidirecional
            
            occurrence = new Occurrence("Yellow", "Delay", new Date());
            occurrence.setDevice(device); //enlace bidirecional
            occurrenceDao.create(occurrence);
            device.getOccurrenceList().add(occurrence); //enlace bidirecional
        }
        else {
            System.out.println(device.toString());
            System.out.println(device.getParameter().toString());
            System.out.println(device.getLimit().toString());
            System.out.println(device.getData().toString());
            
            List<Occurrence> occurrences = device.getOccurrenceList();
            for(Occurrence occurrence : occurrences) {
                occurrence.setDescription("Alteradas");
                occurrenceDao.edit(occurrence);
            }
            
            System.out.println("Excluindo pontos...");
            List<DataGraphic> dataGraphics = device.getData().getDataGraphicList();
            for(DataGraphic dataGraphic : dataGraphics) {
                dataGraphicDao.destroy(dataGraphic.getDataGraphicId());
            }
            
            System.out.println("Incluindo pontos...");
            for(int i = 0; i < 50; i++) {
                DataGraphic dataGraphic = new DataGraphic(device.getData(), i); //enlace bidirecional
                dataGraphicDao.create(dataGraphic);
                device.getData().getDataGraphicList().add(dataGraphic); //enlace bidirecional
            }
            
            List<Device> devices = user.getDeviceList();
            for(Device d : devices) {
                System.out.println(d.toString());
            }
        }
        
        System.out.println("fim...");
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
