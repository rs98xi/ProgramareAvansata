package com;

import java.text.DateFormatSymbols;
import java.text.MessageFormat;
import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Arrays;
import java.util.Currency;
import java.util.Locale;
import java.util.ResourceBundle;

public class NewClass {

    private Locale locale;
    private ResourceBundle resources;
    private DateFormatSymbols dateFormatSymbols;

    private String prompt;
    private String info;
    private String invalid;
    private String locales;

    public NewClass() {
        this.dateFormatSymbols = DateFormatSymbols.getInstance();
        locale = new Locale("ro", "RO");
        resources = ResourceBundle.getBundle("res.Messages", locale);
        setLocale("ro","RO");
    }

    public void info() {
        Object[] arguments = {locale.getDisplayLanguage()};
        String msg = new MessageFormat(resources.getString("info")).format(arguments);
        System.out.println(msg);
        Currency currency = Currency.getInstance(locale);
        DateFormatSymbols symbols = new DateFormatSymbols(locale);

        System.out.println("Country: " + locale.getDisplayCountry(locale) + " (" + locale.getDisplayCountry() + ")");
        System.out.println("Language: " + locale.getDisplayLanguage(locale) + " (" + locale.getDisplayLanguage() + ")");

        String curencyName = NumberFormat.getCurrencyInstance(locale).format(1);
        System.out.println("Currency: " + currency.getDisplayName(locale) + " (" + curencyName + ")");

        String weekDays = Arrays.toString(symbols.getWeekdays());
        System.out.println("Week Days: " + weekDays.substring(2, weekDays.length()-1));
        String months = Arrays.toString(symbols.getMonths());
        System.out.println("Months: " + months.substring(1, months.length() - 3));

        LocalDateTime today = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL).withLocale(locale);
        System.out.println("Today: " + today.format(formatter));
    }

    public void displayLocales() {
        System.out.println(locales);
        Locale[] available = Locale.getAvailableLocales();
        for (Locale locale : available) {
            System.out.println(locale.getDisplayCountry() + " - " + locale.getDisplayLanguage(locale));
        }
    }

    public void setLocale(String language, String country) {
        locale = new Locale(language, country);
        resources = ResourceBundle.getBundle("res.Messages", locale);
        prompt = resources.getString("prompt");
        info = resources.getString("info");
        invalid = resources.getString("invalid");
        locales = resources.getString("locales");
    }


    public String getPrompt() {
        return prompt;
    }

    public String getInfo() {
        return info;
    }

    public String getInvalid() {
        return invalid;
    }

    public String getLocales() {
        return locales;
    }

    public DateFormatSymbols getDateFormatSymbols() {
        return dateFormatSymbols;
    }

    public void setDateFormatSymbols(DateFormatSymbols dateFormatSymbols) {
        this.dateFormatSymbols = dateFormatSymbols;
    }
}
