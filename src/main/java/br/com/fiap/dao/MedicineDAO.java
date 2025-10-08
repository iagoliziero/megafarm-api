package br.com.fiap.dao;

import br.com.fiap.to.MedicineTO;
 import br.com.fiap.to.MedicineTO;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

public class MedicineDAO {
    public ArrayList<MedicineTO> findAll() {
        ArrayList<MedicineTO> remedios = new ArrayList<>();
        MedicineTO remedio = new MedicineTO(1L, "Loratadina", 7.93, LocalDate.parse("2023-10-10"), LocalDate.parse("2025-10-10"));
        remedios.add(remedio);
        remedio = new MedicineTO(2L, "Amoxicilina", 26.50, LocalDate.now(), LocalDate.now().plusYears(2));
        remedios.add(remedio);
        remedio = new MedicineTO(3L, "Metformina", 9.99, LocalDate.now().minusYears(1), LocalDate.now().plusYears(1));
        remedios.add(remedio);
        return remedios;
    }

    public class RemedioDAO {

        public MedicineTO save(MedicineTO medicine) {
            String sql = "insert into ddd_medicine (name, price, data_manufactoring, data_validity) values(?, ?, ?, ?)";

            try (PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)) {
                ps.setString(1, medicine.getName());
                ps.setDouble(2, medicine.getPrice());
                ps.setDate(3, Date.valueOf(medicine.getDataManufacturing()));
                ps.setDate(4, Date.valueOf(medicine.getDateValidity()));

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
}