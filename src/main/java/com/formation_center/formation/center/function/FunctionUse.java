package com.formation_center.formation.center.function;

import com.formation_center.formation.center.model.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FunctionUse {
    //=========TrainingCenter=======//
    public List<TrainingCenter> getAllTrainingCenter(Connection conn) {
        List<TrainingCenter> trainingCenters = new ArrayList<>();
        Statement statement;
        ResultSet rs = null;
        try {
            String query = String.format("select * from training_center;");
            statement = conn.createStatement();
            rs = statement.executeQuery(query);
            while (rs.next()) {
                trainingCenters.add(new TrainingCenter(
                        rs.getInt("id_training_center"),
                        rs.getString("name"),
                        rs.getString("address"),
                        rs.getString("contact_details"),
                        rs.getString("equipment")
                ));
            }

        } catch (Exception e) {
            throw new RuntimeException("fix it : ", e);
        }
        return trainingCenters;
    }

    public List<TrainingCenter> getTrainingCenterById(Connection conn, int id) {
        List<TrainingCenter> trainingCenters = new ArrayList<>();
        Statement statement;
        ResultSet rs = null;
        try {
            String query = String.format("select * from training_center where id_training_center='%s';", id);
            statement = conn.createStatement();
            rs = statement.executeQuery(query);
            while (rs.next()) {
                trainingCenters.add(new TrainingCenter(
                        rs.getInt("id_training_center"),
                        rs.getString("name"),
                        rs.getString("address"),
                        rs.getString("contact_details"),
                        rs.getString("equipment")
                ));
            }

        } catch (Exception e) {
            throw new RuntimeException("fix it : ", e);
        }
        return trainingCenters;
    }

    public void deleteTrainingCenter(Connection conn, int id) {
        Statement statement;
        try {
            String query = String.format("delete from training_center where id_training_center='%s';", id);
            statement = conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("delete training center , id : " + id + " is done ✔");
        } catch (Exception e) {
            throw new RuntimeException("fix it : ", e);
        }
    }

    public void addTrainingCenter(Connection conn, TrainingCenter trainingCenter) {
        Statement statement;
        try {
            String query = String.format("INSERT INTO training_center (name, address, " +
                            "contact_details, equipment)" +
                            " VALUES ('%s','%s','%s','%s')", trainingCenter.getName(),
                    trainingCenter.getAddress(), trainingCenter.getContactDetails()
                    , trainingCenter.getEquipment());
            statement = conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("add training center , done ✔");
        } catch (Exception e) {
            throw new RuntimeException("fix it : ", e);
        }
    }

    public void updateTrainingCenter(Connection conn, String columnName, String value, int id) {
        PreparedStatement preparedStatement = null;
        try {
            String query = String.format("UPDATE training_center SET %s = ? WHERE id_training_center = ?", columnName);
            preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, value);
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();
            System.out.println(columnName + " in training center updated ✔");
        } catch (SQLException e) {
            throw new RuntimeException("fix it : ", e);
        }
    }
    //=========End of TrainingCenter=======//


    //=========ClassSession=======//
    public List<ClassSession> getAllClassSession(Connection conn) {
        List<ClassSession> classSessions = new ArrayList<>();
        Statement statement;
        ResultSet rs = null;
        try {
            String query = String.format("select * from class_session;");
            statement = conn.createStatement();
            rs = statement.executeQuery(query);
            while (rs.next()) {
                classSessions.add(new ClassSession(
                        rs.getInt("id"),
                        rs.getString("date_session"),
                        rs.getString("hour"),
                        rs.getString("subject"),
                        rs.getString("idteacher")
                ));
            }

        } catch (Exception e) {
            throw new RuntimeException("fix it : ", e);
        }
        return classSessions;
    }

    public List<ClassSession> getClassSessionById(Connection conn, int id) {
        List<ClassSession> classSessions = new ArrayList<>();
        Statement statement;
        ResultSet rs = null;
        try {
            String query = String.format("select * from class_session where id='%s';", id);
            statement = conn.createStatement();
            rs = statement.executeQuery(query);
            while (rs.next()) {
                classSessions.add(new ClassSession(
                        rs.getInt("id"),
                        rs.getString("date_session"),
                        rs.getString("hour"),
                        rs.getString("subject"),
                        rs.getString("idteacher")
                ));
            }

        } catch (Exception e) {
            throw new RuntimeException("fix it : ", e);
        }
        return classSessions;
    }

    public void deleteClassSession(Connection conn, int id) {
        Statement statement;
        try {
            String query = String.format("delete from class_session where id='%s';", id);
            statement = conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("delete class_session , id : " + id + " is done ✔");
        } catch (Exception e) {
            throw new RuntimeException("fix it : ", e);
        }
    }

    public void addClassSession(Connection conn, ClassSession classSession) {
        Statement statement;
        try {
            String query = String.format("INSERT INTO class_session (date_session, hour," +
                            " subject, idTeacher) VALUES('%s','%s','%s','%s')",
                    classSession.getDateSession(), classSession.getHour(),
                    classSession.getSubject(), classSession.getIdTeacher());

            statement = conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("add class_session , done ✔");
        } catch (Exception e) {
            throw new RuntimeException("fix it : ", e);
        }
    }

    public void updateClassSession(Connection conn, String columnName, String value, int id) {
        PreparedStatement preparedStatement = null;
        try {
            String query = String.format("UPDATE class_session SET %s = ? WHERE id = ?", columnName);
            preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, value);
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();
            System.out.println(columnName + " in class_session updated ✔");
        } catch (SQLException e) {
            throw new RuntimeException("fix it : ", e);
        }
    }
    //=========End of ClassSession=======//

    //=========Course=======//
    public List<String> getAllCourse(Connection conn) {
        List<String> courses = new ArrayList<>();
        Statement statement = null;
        ResultSet rs = null;
        try {
            String query = "SELECT \n" +
                    "    c.id_course,\n" +
                    "    c.title,\n" +
                    "    c.description,\n" +
                    "    c.price,\n" +
                    "    c.schedules,\n" +
                    "    t.id_training_center,\n" +
                    "    t.name AS training_center_name,\n" +
                    "    t.address,\n" +
                    "    t.contact_details,\n" +
                    "    t.equipment,\n" +
                    "    s.id AS class_session_id,\n" +
                    "    s.date_session,\n" +
                    "    s.hour,\n" +
                    "    s.subject,\n" +
                    "    s.idTeacher\n" +
                    "FROM \n" +
                    "    course c\n" +
                    "JOIN \n" +
                    "    training_center t ON c.id_training_center = t.id_training_center\n" +
                    "JOIN \n" +
                    "    class_session s ON c.id_class_session = s.id;\n";
            statement = conn.createStatement();
            rs = statement.executeQuery(query);
            while (rs.next()) {
                String course = String.format("course_id: %d, title: %s, description: %s, price: %.2f, schedules: %s, " +
                                "training_center_id: %d, training_center_name: %s, address: %s, contact_details: %s, equipment: %s, " +
                                "class_session_id: %d, date_session: %s, hour: %s, subject: %s, teacher_id: %s",
                        rs.getInt("id_course"),
                        rs.getString("title"),
                        rs.getString("description"),
                        rs.getDouble("price"),
                        rs.getString("schedules"),
                        rs.getInt("id_training_center"),
                        rs.getString("training_center_name"),
                        rs.getString("address"),
                        rs.getString("contact_details"),
                        rs.getString("equipment"),
                        rs.getInt("class_session_id"),
                        rs.getString("date_session"),
                        rs.getString("hour"),
                        rs.getString("subject"),
                        rs.getString("idTeacher"));
                courses.add(course);
            }
        } catch (Exception e) {
            throw new RuntimeException("fix it : ", e);
        } finally {
            try {
                if (rs != null) rs.close();
                if (statement != null) statement.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return courses;
    }

    public List<String> getCourseById(Connection conn, int id) {
        List<String> courses = new ArrayList<>();
        Statement statement = null;
        ResultSet rs = null;
        try {

            String query = String.format("SELECT " +
                    "    c.id_course, " +
                    "    c.title, " +
                    "    c.description, " +
                    "    c.price, " +
                    "    c.schedules, " +
                    "    t.id_training_center, " +
                    "    t.name AS training_center_name, " +
                    "    t.address, " +
                    "    t.contact_details, " +
                    "    t.equipment, " +
                    "    s.id AS class_session_id, " +
                    "    s.date_session, " +
                    "    s.hour, " +
                    "    s.subject, " +
                    "    s.idTeacher " +
                    "FROM " +
                    "    course c " +
                    "JOIN " +
                    "    training_center t ON c.id_training_center = t.id_training_center " +
                    "JOIN " +
                    "    class_session s ON c.id_class_session = s.id " +
                    "WHERE " +
                    "    c.id_course = %d;", id);

            statement = conn.createStatement();

            rs = statement.executeQuery(query);

            while (rs.next()) {
                String course = String.format("course_id: %d, title: %s, description: %s, price: %.2f, schedules: %s, " +
                                "training_center_id: %d, training_center_name: %s, address: %s, contact_details: %s, equipment: %s, " +
                                "class_session_id: %d, date_session: %s, hour: %s, subject: %s, teacher_id: %s",
                        rs.getInt("id_course"),
                        rs.getString("title"),
                        rs.getString("description"),
                        rs.getDouble("price"),
                        rs.getString("schedules"),
                        rs.getInt("id_training_center"),
                        rs.getString("training_center_name"),
                        rs.getString("address"),
                        rs.getString("contact_details"),
                        rs.getString("equipment"),
                        rs.getInt("class_session_id"),
                        rs.getString("date_session"),
                        rs.getString("hour"),
                        rs.getString("subject"),
                        rs.getString("idTeacher"));
                courses.add(course);
            }
        } catch (Exception e) {
            throw new RuntimeException("Error while retrieving course by ID: ", e);
        } finally {
            try {
                if (rs != null) rs.close();
                if (statement != null) statement.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return courses;
    }

    public void deleteCourse(Connection conn, int id) {
        Statement statement;
        try {
            String query = String.format("delete from course where id_course='%s';", id);
            statement = conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("delete id_course , id : " + id + " is done ✔");
        } catch (Exception e) {
            throw new RuntimeException("fix it : ", e);
        }
    }

    public void addCourse(Connection conn, Course course) {
        Statement statement;
        try {
            String query = String.format("INSERT INTO course (title, description, price, schedules, " +
                            "id_training_center, id_class_session) VALUES('%s','%s','%s','%s','%s','%s')",
                    course.getTitle(), course.getDescription(), course.getPrice(),
                    course.getSchedules(), course.getIdTrainingCenter(), course.getIdClassSession());

            statement = conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("add course , done ✔");
        } catch (Exception e) {
            throw new RuntimeException("fix it : ", e);
        }
    }

    public void updateCourse(Connection conn, String columnName, String value, int id) {
        PreparedStatement preparedStatement = null;
        try {
            String query = String.format("UPDATE course SET %s = ? WHERE id_course = ?", columnName);
            preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, value);
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();
            System.out.println(columnName + " in course updated ✔");
        } catch (SQLException e) {
            throw new RuntimeException("fix it : ", e);
        }
    }

    //=========End of Course=======//

    //=========Registration=======//
    public List<Registration> getAllRegistration(Connection conn) {
        List<Registration> registrations = new ArrayList<>();
        Statement statement;
        ResultSet rs = null;
        try {
            String query = String.format("select * from registration;");
            statement = conn.createStatement();
            rs = statement.executeQuery(query);
            while (rs.next()) {
                registrations.add(new Registration(
                        rs.getInt("id_registration"),
                        rs.getString("date_registration"),
                        rs.getString("status"),
                        rs.getString("id_user"),
                        rs.getInt("id_course")
                ));
            }

        } catch (Exception e) {
            throw new RuntimeException("fix it : ", e);
        }
        return registrations;
    }

    public List<Registration> getRegistrationById(Connection conn, int id) {
        List<Registration> registrations = new ArrayList<>();
        Statement statement;
        ResultSet rs = null;
        try {
            String query = String.format("select * from registration where id_registration='%s';", id);
            statement = conn.createStatement();
            rs = statement.executeQuery(query);
            while (rs.next()) {
                registrations.add(new Registration(
                        rs.getInt("id_registration"),
                        rs.getString("date_registration"),
                        rs.getString("status"),
                        rs.getString("id_user"),
                        rs.getInt("id_course")
                ));
            }

        } catch (Exception e) {
            throw new RuntimeException("fix it : ", e);
        }
        return registrations;
    }

    public void deleteRegistration(Connection conn, int id) {
        Statement statement;
        try {
            String query = String.format("delete from registration where id_registration='%s';", id);
            statement = conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("delete registration , id : " + id + " is done ✔");
        } catch (Exception e) {
            throw new RuntimeException("fix it : ", e);
        }
    }

    public void addRegistration(Connection conn, Registration registration) {
        Statement statement;
        try {
            String query = String.format("INSERT INTO registration (date_registration, status," +
                            " id_user, id_course) VALUES('%s','%s','%s','%s')",
                    registration.getDateRegistration(), registration.getStatus(),
                    registration.getIdUser(), registration.getIdCourse());

            statement = conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("add registration , done ✔");
        } catch (Exception e) {
            throw new RuntimeException("fix it : ", e);
        }
    }

    public void updateRegistration(Connection conn, String columnName, String value, int id) {
        PreparedStatement preparedStatement = null;
        try {
            String query = String.format("UPDATE registration SET %s = ? WHERE id_registration = ?", columnName);
            preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, value);
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();
            System.out.println(columnName + " in registration updated ✔");
        } catch (SQLException e) {
            throw new RuntimeException("fix it : ", e);
        }
    }

    //=========End of Registration=======//

    //=========Wave=======//

    public List<Wave> getAllWave(Connection conn) {
        List<Wave> waves = new ArrayList<>();
        Statement statement;
        ResultSet rs = null;
        try {
            String query = String.format("select * from wave;");
            statement = conn.createStatement();
            rs = statement.executeQuery(query);
            while (rs.next()) {
                waves.add(new Wave(
                        rs.getInt("id_wave"),
                        rs.getInt("id_course"),
                        rs.getString("start_date"),
                        rs.getString("end_date")
                ));
            }

        } catch (Exception e) {
            throw new RuntimeException("fix it : ", e);
        }
        return waves;
    }

    public List<Wave> getWaveById(Connection conn, int id) {
        List<Wave> waves = new ArrayList<>();
        Statement statement;
        ResultSet rs = null;
        try {
            String query = String.format("select * from wave where id_wave='%s';", id);
            statement = conn.createStatement();
            rs = statement.executeQuery(query);
            while (rs.next()) {
                waves.add(new Wave(
                        rs.getInt("id_wave"),
                        rs.getInt("id_course"),
                        rs.getString("start_date"),
                        rs.getString("end_date")
                ));
            }

        } catch (Exception e) {
            throw new RuntimeException("fix it : ", e);
        }
        return waves;
    }

    public void deleteWave(Connection conn, int id) {
        Statement statement;
        try {
            String query = String.format("delete from wave where id_wave='%s';", id);
            statement = conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("delete wave , id : " + id + " is done ✔");
        } catch (Exception e) {
            throw new RuntimeException("fix it : ", e);
        }
    }

    public void addWave(Connection conn, Wave wave) {
        Statement statement;
        try {
            String query = String.format("INSERT INTO wave (id_course, start_date, end_date)" +
                    " VALUES('%s','%s','%s')", wave.getIdCourse(), wave.getStartDate(), wave.getEndDate());

            statement = conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("add wave , done ✔");
        } catch (Exception e) {
            throw new RuntimeException("fix it : ", e);
        }
    }

    public void updateWave(Connection conn, String columnName, String value, int id) {
        PreparedStatement preparedStatement = null;
        try {
            String query = String.format("UPDATE wave SET %s = ? WHERE id_wave = ?", columnName);
            preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, value);
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();
            System.out.println(columnName + " in wave updated ✔");
        } catch (SQLException e) {
            throw new RuntimeException("fix it : ", e);
        }
    }

    //=========End Of Wave=======//
}

