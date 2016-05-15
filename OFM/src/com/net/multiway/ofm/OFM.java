/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.net.multiway.ofm;

import com.net.multiway.ofm.daos.DataDAO;
import com.net.multiway.ofm.daos.DataEventDAO;
import com.net.multiway.ofm.daos.DataGraphicDAO;
import com.net.multiway.ofm.daos.DeviceDAO;
import com.net.multiway.ofm.daos.LimitDAO;
import com.net.multiway.ofm.daos.OccurrenceDAO;
import com.net.multiway.ofm.daos.ParameterDAO;
import com.net.multiway.ofm.daos.UserDAO;
import com.net.multiway.ofm.daos.exceptions.IllegalOrphanException;
import com.net.multiway.ofm.entities.Data;
import com.net.multiway.ofm.entities.DataEvent;
import com.net.multiway.ofm.entities.DataGraphic;
import com.net.multiway.ofm.entities.Device;
import com.net.multiway.ofm.entities.Limit;
import com.net.multiway.ofm.entities.Occurrence;
import com.net.multiway.ofm.entities.Parameter;
import com.net.multiway.ofm.entities.User;
import java.util.Date;
import java.util.List;
import javafx.application.Application;
import javafx.stage.Stage;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author phelipe
 */
public class OFM extends Application {

    private EntityManagerFactory emf;

    @Override
    public void start(Stage primaryStage) throws IllegalOrphanException, Exception {
        emf = Persistence.createEntityManagerFactory("OFMPU");

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
            user = new User();
            user.setUsername("admin");
            user.setEmail("teste@vai.dar.certo");
            user.setPassword("13");
            user.setCreateTime(new Date());
            userDao.create(user);
        }
        System.out.println(user.getEmail());

        Device device = deviceDao.findDevice(1);
        if (device == null) {
            device = new Device();
            device.setName("DEVICE_1");
            device.setIp("123");
            device.setMask("1");
            device.setGateway("2");
            device.setUser(user);
            device.setCreateTime(new Date());
            deviceDao.create(device);

            Parameter parameter = new Parameter(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, new Date());
            parameter.setDevice(device); // enlace bidirecional
            parameter.setUser(user);
            parameterDao.create(parameter);
            device.setParameter(parameter); // enlace bidirecional

            Limit limit = new Limit(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, new Date());
            limit.setDevice(device); // enlace bidirecional
            limit.setUser(user);
            limitDao.create(limit);
            device.setLimit(limit); //enlace bidirecional

            Data data = new Data(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
            data.setDevice(device); //enlace bidirecional
            dataDao.create(data);
            device.setData(data); //enlace bidirecional
            
            for(int i = 0; i < 15000; i++) {
                DataGraphic dataGraphic = new DataGraphic(data, i); //enlace bidirecional
                dataGraphicDao.create(dataGraphic);
                data.getDataGraphicList().add(dataGraphic); //enlace bidirecional
            }
            
            for(int i = 0; i < 5; i++) {
                DataEvent dataEvent = new DataEvent(0, 0, 0, 0, 0, 0);
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
            
            Data data = device.getData();
            
//            List<DataEvent> dataEvents = data.getDataEventList();
//            for(DataEvent dataEvent : dataEvents) {
//                System.out.println(dataEvent.toString());
//            }
            
            System.out.println("Excluindo pontos...");
            List<DataGraphic> dataGraphics = data.getDataGraphicList();
            for(DataGraphic dataGraphic : dataGraphics) {
                dataGraphicDao.destroy(dataGraphic.getDataGraphicId());
            }
            
            System.out.println("Criando pontos...");
            for(int i = 0; i < 15000; i++) {
                DataGraphic dataGraphic = new DataGraphic(data, i); //enlace bidirecional
                dataGraphicDao.create(dataGraphic);
                data.getDataGraphicList().add(dataGraphic); //enlace bidirecional
            }
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
