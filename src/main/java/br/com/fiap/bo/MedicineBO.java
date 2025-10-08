package br.com.fiap.bo;

import br.com.fiap.dao.MedicineDAO;
import br.com.fiap.to.MedicineTO;

import java.time.LocalDate;
import java.util.ArrayList;

    public class MedicineBO {

        private MedicineDAO medicineDAO;

        public ArrayList<MedicineTO> findAll() {
            medicineDAO = new MedicineDAO();

            return medicineDAO.findAll();
        }

        public MedicineTO save(MedicineTO medicine) {
            MedicineDAO medicineDAO = new MedicineDAO();

            if(medicine.getDataManufacturing().isBefore(LocalDate.now())) {
                return null;
            }

            return medicineDAO.save(medicine);
        }
}
