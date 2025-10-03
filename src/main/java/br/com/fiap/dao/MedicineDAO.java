package br.com.fiap.dao;

import br.com.fiap.to.MedicineTO;

import java.time.LocalDate;
import java.util.ArrayList;

public class MedicineDAO {
    public ArrayList<MedicineTO> findAll() {

        ArrayList<MedicineTO> medicines = new ArrayList<>();
        MedicineTO medicine = new MedicineTO(1L, "Loratadine", 7.93, LocalDate.parse("2023-10-10"), LocalDate.parse("20265-10-10"));
        medicines.add(medicine);

        medicine = new MedicineTO(2L, "Amoxiline", 26.50, LocalDate.now(), LocalDate.now().plusYears(2));
        medicines.add(medicine);

        return medicines;
    }
}
