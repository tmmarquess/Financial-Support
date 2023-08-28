package com.financial.support;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.financial.support.enums.Months;
import com.financial.support.enums.TransactionType;
import com.financial.support.model.FinancialMonth;
import com.financial.support.model.FixCommings;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) throws ParseException {

        DateFormat formatter = new SimpleDateFormat("dd/mm/yyyy");

        FinancialMonth august = new FinancialMonth(Months.August, 2023);

        FixCommings fixCommings = new FixCommings(true);

        fixCommings.addFixCome(1131.49, "Salário 1/2", "salário", formatter.parse("30/07/2023"),
                TransactionType.Income);
        fixCommings.addFixCome(901.60, "Salário 2/2", "salário", formatter.parse("15/08/2023"), TransactionType.Income);

        fixCommings.addFixCome(170.73, "Internet", "Moradia", formatter.parse("05/08/2023"), TransactionType.Outcome);
        fixCommings.addFixCome(5.81, "Spotify", "Lazer", formatter.parse("05/08/2023"), TransactionType.Outcome);
        fixCommings.addFixCome(fixCommings.getIncomes() / 10, "Dízimo", "Dízimo", formatter.parse("05/08/2023"),
                TransactionType.Outcome);

        august.setFixCommings(fixCommings);

        System.out.println(String.format("%.2f", august.getTotalIncomes()));
        System.out.println(String.format("%.2f", august.getTotalOutcomes()));
        System.out.println(String.format("%.2f", august.getTotalAvailable()));
    }
}
