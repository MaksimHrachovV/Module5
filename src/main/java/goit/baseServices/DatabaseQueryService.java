package goit.baseServices;

import goit.modelRequests.LongestProject;
import goit.modelRequests.MaxProjectCountClient;
import goit.modelRequests.MaxSalaryWorker;
import goit.modelRequests.YoungestEldestWorkers;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DatabaseQueryService {

    public List<YoungestEldestWorkers> findYoungestEldestWorkers(Database database) {
        List<YoungestEldestWorkers> listYoungestEldestWorkers = new ArrayList<>();
        String query = database.ReadFileAndCreat("sql/find_youngest_eldest_workers.sql");
        try (Connection connection = database.getConnection()) {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                String type = rs.getString("type");
                String name = rs.getString("name");
                Date birthday=rs.getDate("birthday");
                YoungestEldestWorkers youngestEldestWorkers = new YoungestEldestWorkers(type, name, birthday);
                listYoungestEldestWorkers.add(youngestEldestWorkers);
            }
            return listYoungestEldestWorkers;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    public List<MaxSalaryWorker> findMaxSalaryWorker(Database database) {
        List<MaxSalaryWorker> listMaxSalaryWorker = new ArrayList<>();
        String query = database.ReadFileAndCreat("sql/find_max_salary_worker.sql");
        try (Connection connection = database.getConnection()) {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                Date birthday=rs.getDate("birthday");
                String level = rs.getString("level");
                int salary = rs.getInt("salary");
                MaxSalaryWorker maxSalaryWorker = new MaxSalaryWorker(id, name, birthday,level, salary);
                listMaxSalaryWorker.add(maxSalaryWorker);
            }
            return listMaxSalaryWorker;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


    public List<LongestProject> findLongestProject(Database database) {
        List<LongestProject> listLongestProject = new ArrayList<>();
        String query = database.ReadFileAndCreat("sql/find_longest_project.sql");
        try (Connection connection = database.getConnection()) {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                int name = rs.getInt("name");
                int duration = rs.getInt("duration");
                LongestProject longestProject = new LongestProject(name, duration);
                listLongestProject.add(longestProject);
            }
            return listLongestProject;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public List<MaxProjectCountClient> findMaxProjectsClient(Database database) {
        List<MaxProjectCountClient> listMaxProjectCountClients = new ArrayList<>();
        String query = database.ReadFileAndCreat("sql/find_max_projects_client.sql");
        try (Connection connection = database.getConnection()) {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                int workid = rs.getInt("WORKER_ID");
                int projectid = rs.getInt("COUNT(PROJECT_ID)");
                MaxProjectCountClient maxProjectCountClient = new MaxProjectCountClient(workid, projectid);
                listMaxProjectCountClients.add(maxProjectCountClient);
            }
            return listMaxProjectCountClients;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}

