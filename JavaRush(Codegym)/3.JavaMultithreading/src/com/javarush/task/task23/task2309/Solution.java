package com.javarush.task.task23.task2309;

import com.javarush.task.task23.task2309.vo.*;

import java.util.List;

/* 
Анонимность иногда так приятна!
*/
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        print(solution.getUsers());
        print(solution.getLocations());
    }

    public static void print(List list) {
        String format = "Id=%d, name='%s', description=%s";
        for (Object obj : list) {
            NamedItem item = (NamedItem) obj;
            System.out.println(String.format(format, item.getId(), item.getName(), item.getDescription()));
        }
    }
    public List<User> getUsers(){
        AbstractDbSelectExecutor<User> userA = new AbstractDbSelectExecutor<User>(){
            @Override
            public String getQuery() {

                return "SELECT * FROM USER";
            }
        };

        return userA.execute();
    }

    public List<Location> getLocations(){
        AbstractDbSelectExecutor<Location> locationA = new AbstractDbSelectExecutor<Location>(){
            @Override
            public String getQuery() {
                return "SELECT * FROM LOCATION";
            }
        };
        return locationA.execute();
    }
    public List<Server> getServers(){
        AbstractDbSelectExecutor<Server> serverA = new AbstractDbSelectExecutor<Server>(){
            @Override
            public String getQuery() {
                return "SELECT * FROM SERVER";
            }
        };
        return serverA.execute();
    }
    public List<Subject> getSubjects(){
        AbstractDbSelectExecutor<Subject> subjectA = new AbstractDbSelectExecutor<Subject>(){
            @Override
            public String getQuery() {
                return "SELECT * FROM SUBJECT";
            }
        };
        return subjectA.execute();
    }
    public List<Subscription> getSubscriptions(){
        AbstractDbSelectExecutor<Subscription> subscriptionA = new AbstractDbSelectExecutor<Subscription>(){
            @Override
            public String getQuery() {
                return "SELECT * FROM SUBSCRIPTION";
            }
        };
        return subscriptionA.execute();
    }

}
