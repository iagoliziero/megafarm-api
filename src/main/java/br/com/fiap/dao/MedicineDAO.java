package br.com.fiap.dao;

import br.com.fiap.to.MedicineTO;
 import br.com.fiap.to.MedicineTO;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

public class MedicineDAO {

        public ArrayList<MedicineTO> findAll() {
            String sql = "select * from ddd_medicine order by cod";

            try(PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery();

                if(rs != null) {
                    while (rs.next()) {
                        MedicineTO medicine = new MedicineTO();
                        medicine.setCod(rs.getLong("cod"));
                        medicine.setName(rs.getString("name"));
                        medicine.setPrice(rs.getDouble("price"));
                        medicine.setDataManufactoring(rs.getDate("data_manufacturing").toLocalDate());
                        medicine.setDataValidity(rs.getDate("data_validity").toLocalDate());
                    }
                } else {
                    return null;
                }

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            return null;
        }

        public MedicineTO save(MedicineTO medicine) {
            String sql = "insert into ddd_medicine (name, price, data_manufacturing, data_validity) values(?, ?, ?, ?)";

            try (PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)) {
                ps.setString(1, medicine.getName());
                ps.setDouble(2, medicine.getPrice());
                ps.setDate(3, Date.valueOf(medicine.getDataManufacturing()));
                ps.setDate(4, Date.valueOf(medicine.getDataValidity()));

                if (ps.executeUpdate() > 0) {
                    return medicine;
                } else {
                    return null;
                }
            } catch (SQLException e) {
                System.out.println("save error: " + e.getMessage());
            } finally {
                ConnectionFactory.closeConnection();
            }

            return null;
    }
}