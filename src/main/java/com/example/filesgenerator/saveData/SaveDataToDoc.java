package com.example.filesgenerator.saveData;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import javafx.scene.control.DatePicker;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import java.awt.Desktop;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class SaveDataToDoc {
    static LocalDate currentDate = LocalDate.now();
    static String searchText1 = "pojazdposzk";
    static String searchText2 = "poszkodnumerrej";
    static String searchText3 = "zusprawcy";
    static String searchText4 = "polisaocsprawcy";
    static String searchText5 = "datazawarcia";
    static String searchText6 = "miejscowosc";
    static String searchText7 = "nazwaspolki";
    static String searchText8 = "nrnip";
    static String searchText9 = "imieinazwiskoposzk";
    static String searchText10 = "kodimiejs";
    static String searchText11 = "ulinrbudlok";
    static String searchText12 = "seriadowodu";
    static String searchText13 = "dowodnumer";
    static String searchText14 = "wynajmowanypojazd";
    static String searchText15 = "nrrejwynajmowany";
    static String searchText16 = "vinwynajmowany";
    static String searchText17 = "paliwowynajmowany";
    static String searchText18 = "stawkanajmu";
    static String searchText19 = "segmentwynajmowany";
    static String searchText20 = "sprawcanrrej";
    static String searchText21 = "szkodynr";
    static String searchText22 = "miejsczdarz";
    static String searchText23 = "telposzk";
    static String searchText24 = "poszkmail";
    static String searchText25 = "datazwrotu";
    static String searchText26 = "databiezaca";


    public static void saveUmowaNajmu(String replacePojazdPoszkodowanego, String replaceNrRejPoszkodowanego,
                                      String replaceZuSprawcy, String replaceNrSzkody,
                                      DatePicker replaceDataZawarcia, String replaceMiejsceUmowy, String replaceMiejscowosc,
                                      String replaceSpolka, String replaceNip,
                                      String replaceImieNazwiskoPoszkodowanego, String replaceKodPocztowy,
                                      String replaceUlicaNumer, String replaceSeriaDowodu,
                                      String replaceNrDowodu, String replaceWynajmowanyPojazd,
                                      String replaceNrRejWynajmowanegoPojazdu, String replaceVinWynajmowanego,
                                      String replacePaliwo, String replaceStawka, String replaceSegment) {
        try {
            XWPFDocument document = new XWPFDocument(new FileInputStream(System.getProperty("user.home") + "/Desktop/Pliki generatora/Pliki źródłowe-NIE RUSZAĆ/UMOWA NAJMU.docx"));

            for (XWPFParagraph paragraph : document.getParagraphs()) {
                for (XWPFRun run : paragraph.getRuns()) {
                    String text = run.getText(0);
                    if (text != null && text.contains(searchText1)) {
                        text = text.replace(searchText1, replacePojazdPoszkodowanego.isEmpty() ? "....................................." : replacePojazdPoszkodowanego);
                        run.setText(text, 0);
                    } else if (text != null && text.contains(searchText2)) {
                        text = text.replace(searchText2, replaceNrRejPoszkodowanego.isEmpty() ? "....................................." : replaceNrRejPoszkodowanego);
                        run.setText(text, 0);
                    } else if (text != null && text.contains(searchText3)) {
                        String replaceText = replaceZuSprawcy != null ? replaceZuSprawcy : ".....................................";
                        text = text.replace(searchText3, replaceText);
                        run.setText(text, 0);
                    } else if (text != null && text.contains(searchText21)) {
                        text = text.replace(searchText21, replaceNrSzkody.isEmpty() ? "....................................." : replaceNrSzkody);
                        run.setText(text, 0);
                    } else if (text != null && text.contains(searchText5)) {
                        if (replaceDataZawarcia.getValue() != null) {
                            text = text.replace(searchText5, replaceDataZawarcia.getValue().format(DateTimeFormatter.ofPattern("dd.MM.yyyy")));
                            run.setText(text, 0);
                        } else {
                            text = text.replace(searchText5, ".....................................");
                            run.setText(text, 0);
                        }
                    } else if (text != null && text.contains(searchText6)) {
                        text = text.replace(searchText6, replaceMiejsceUmowy.isEmpty() ? "....................................." : replaceMiejsceUmowy);
                        run.setText(text, 0);
                    } else if (text != null && text.contains(searchText7)) {
                        text = text.replace(searchText7, replaceSpolka.isEmpty() ? "....................................." : replaceSpolka);
                        run.setText(text, 0);
                    } else if (text != null && text.contains(searchText8)) {
                        text = text.replace(searchText8, replaceNip.isEmpty() ? "....................................." : replaceNip);
                        run.setText(text, 0);
                    } else if (text != null && text.contains(searchText9)) {
                        text = text.replace(searchText9, replaceImieNazwiskoPoszkodowanego.isEmpty() ? "....................................." : replaceImieNazwiskoPoszkodowanego);
                        run.setText(text, 0);
                    } else if (text != null && text.contains(searchText10)) {
                        if(replaceKodPocztowy.isEmpty() && replaceMiejscowosc.isEmpty()){
                            text = text.replace(searchText10, ".....................................");
                            run.setText(text, 0);
                        }else {
                            text = text.replace(searchText10, replaceKodPocztowy + " " + replaceMiejscowosc);
                            run.setText(text, 0);
                        }
                    } else if (text != null && text.contains(searchText11)) {
                        text = text.replace(searchText11, replaceUlicaNumer.isEmpty() ? "....................................." : replaceUlicaNumer);
                        run.setText(text, 0);
                    } else if (text != null && text.contains(searchText12)) {
                        text = text.replace(searchText12, replaceSeriaDowodu.isEmpty() ? "....................................." : replaceSeriaDowodu);
                        run.setText(text, 0);
                    } else if (text != null && text.contains(searchText13)) {
                        text = text.replace(searchText13, replaceNrDowodu.isEmpty() ? "....................................." : replaceNrDowodu);
                        run.setText(text, 0);
                    } else if (text != null && text.contains(searchText14)) {
                        text = text.replace(searchText14, replaceWynajmowanyPojazd.isEmpty() ? "....................................." : replaceWynajmowanyPojazd);
                        run.setText(text, 0);
                    } else if (text != null && text.contains(searchText15)) {
                        String replaceText2 = replaceNrRejWynajmowanegoPojazdu != null ? replaceNrRejWynajmowanegoPojazdu : ".....................................";
                        text = text.replace(searchText15, replaceText2);
                        run.setText(text, 0);
                    } else if (text != null && text.contains(searchText16)) {
                        text = text.replace(searchText16, replaceVinWynajmowanego.isEmpty() ? "....................................." : replaceVinWynajmowanego);
                        run.setText(text, 0);
                    } else if (text != null && text.contains(searchText17)) {
                        text = text.replace(searchText17, replacePaliwo.isEmpty() ? "....................................." : replacePaliwo);
                        run.setText(text, 0);
                    } else if (text != null && text.contains(searchText18)) {
                        text = text.replace(searchText18, replaceStawka.isEmpty() ? "....................................." : replaceStawka);
                        run.setText(text, 0);
                    } else if (text != null && text.contains(searchText19)) {
                        text = text.replace(searchText19, replaceSegment.isEmpty() ? "....................................." : replaceSegment);
                        run.setText(text, 0);
                    }
                }
            }

            File file = new File(System.getProperty("user.home"), "/Desktop/Pliki generatora/Umowa najmu + załącznik.docx");
            FileOutputStream out = new FileOutputStream(file);
            document.write(out);
            out.close();
            document.close();
            Desktop.getDesktop().open(file);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void saveCesja(DatePicker replaceDataZawarcia, String replaceSpolka,
                                 String replaceNip, String replaceImieNazwiskoPoszkodowanego,
                                 String replaceMiejscowosc, String replaceKodPocztowy,
                                 String replaceUlicaNumer, String replaceSeriaDowodu,
                                 String replaceNrDowodu, String replaceNrRejPoszkodowanego,
                                 String replaceNrRejSprawcy, String replacePolisaOC,
                                 String replaceZuSprawcy) {
        try {
            XWPFDocument document = new XWPFDocument(new FileInputStream(System.getProperty("user.home") + "/Desktop/Pliki generatora/Pliki źródłowe-NIE RUSZAĆ/CESJA WIERZYTELNOŚCI.docx"));

            for (XWPFParagraph paragraph : document.getParagraphs()) {
                for (XWPFRun run : paragraph.getRuns()) {
                    String text = run.getText(0);
                    if (text != null && text.contains(searchText5)) {
                        if (replaceDataZawarcia.getValue() != null) {
                            text = text.replace(searchText5, replaceDataZawarcia.getValue().format(DateTimeFormatter.ofPattern("dd.MM.yyyy")));
                            run.setText(text, 0);
                        } else {
                            text = text.replace(searchText5, ".....................................");
                            run.setText(text, 0);
                        }
                    } else if (text != null && text.contains(searchText7)) {
                        text = text.replace(searchText7, replaceSpolka.isEmpty() ? "....................................." : replaceSpolka);
                        run.setText(text, 0);
                    } else if (text != null && text.contains(searchText8)) {
                        text = text.replace(searchText8, replaceNip.isEmpty() ? "....................................." : replaceNip);
                        run.setText(text, 0);
                    } else if (text != null && text.contains(searchText9)) {
                        text = text.replace(searchText9, replaceImieNazwiskoPoszkodowanego.isEmpty() ? "....................................." : replaceImieNazwiskoPoszkodowanego);
                        run.setText(text, 0);
                    } else if (text != null && text.contains(searchText10)) {
                        if(replaceKodPocztowy.isEmpty() && replaceMiejscowosc.isEmpty()){
                            text = text.replace(searchText10, ".....................................");
                            run.setText(text, 0);
                        }else {
                            text = text.replace(searchText10, replaceKodPocztowy + " " + replaceMiejscowosc);
                            run.setText(text, 0);
                        }
                    } else if (text != null && text.contains(searchText11)) {
                        text = text.replace(searchText11, replaceUlicaNumer.isEmpty() ? "....................................." : replaceUlicaNumer);
                        run.setText(text, 0);
                    } else if (text != null && text.contains(searchText12)) {
                        text = text.replace(searchText12, replaceSeriaDowodu.isEmpty() ? "....................................." : replaceSeriaDowodu);
                        run.setText(text, 0);
                    } else if (text != null && text.contains(searchText13)) {
                        text = text.replace(searchText13, replaceNrDowodu.isEmpty() ? "....................................." : replaceNrDowodu);
                        run.setText(text, 0);
                    } else if (text != null && text.contains(searchText2)) {
                        text = text.replace(searchText2, replaceNrRejPoszkodowanego.isEmpty() ? "....................................." : replaceNrRejPoszkodowanego);
                        run.setText(text, 0);
                    } else if (text != null && text.contains(searchText3)) {
                        text = text.replace(searchText3, replaceZuSprawcy.isEmpty() ? "...................................................................................................................................................." : replaceZuSprawcy);
                        run.setText(text, 0);
                    } else if (text != null && text.contains(searchText4)) {
                        text = text.replace(searchText4, replacePolisaOC.isEmpty() ? "....................................." : replacePolisaOC);
                        run.setText(text, 0);
                    } else if (text != null && text.contains(searchText20)) {
                        text = text.replace(searchText20, replaceNrRejSprawcy.isEmpty() ? "....................................." : replaceNrRejSprawcy);
                        run.setText(text, 0);
                    }
                }
            }

            File file = new File(System.getProperty("user.home"), "/Desktop/Pliki generatora/Cesja wierzytelności.docx");
            FileOutputStream out = new FileOutputStream(file);
            document.write(out);
            out.close();
            document.close();
            Desktop.getDesktop().open(file);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void saveCesjaNaprawa(DatePicker replaceDataZawarcia, String replaceSpolka,
                                        String replaceNip, String replaceImieNazwiskoPoszkodowanego,
                                        String replaceMiejscowosc, String replaceKodPocztowy,
                                        String replaceUlicaNumer, String replaceSeriaDowodu,
                                        String replaceNrDowodu, String replaceNrRejPoszkodowanego,
                                        String replaceNrRejSprawcy, String replacePolisaOC,
                                        String replaceZuSprawcy) {
        try {
            XWPFDocument document = new XWPFDocument(new FileInputStream(System.getProperty("user.home") + "/Desktop/Pliki generatora/Pliki źródłowe-NIE RUSZAĆ/CESJA WIERZYTELNOŚCI NAPRAWA.docx"));

            for (XWPFParagraph paragraph : document.getParagraphs()) {
                for (XWPFRun run : paragraph.getRuns()) {
                    String text = run.getText(0);
                    if (text != null && text.contains(searchText5)) {
                        if (replaceDataZawarcia.getValue() != null) {
                            text = text.replace(searchText5, replaceDataZawarcia.getValue().format(DateTimeFormatter.ofPattern("dd.MM.yyyy")));
                            run.setText(text, 0);
                        } else {
                            text = text.replace(searchText5, ".....................................");
                            run.setText(text, 0);
                        }
                    } else if (text != null && text.contains(searchText7)) {
                        text = text.replace(searchText7, replaceSpolka.isEmpty() ? "....................................." : replaceSpolka);
                        run.setText(text, 0);
                    } else if (text != null && text.contains(searchText8)) {
                        text = text.replace(searchText8, replaceNip.isEmpty() ? "....................................." : replaceNip);
                        run.setText(text, 0);
                    } else if (text != null && text.contains(searchText9)) {
                        text = text.replace(searchText9, replaceImieNazwiskoPoszkodowanego.isEmpty() ? "....................................." : replaceImieNazwiskoPoszkodowanego);
                        run.setText(text, 0);
                    } else if (text != null && text.contains(searchText10)) {
                        if(replaceKodPocztowy.isEmpty() && replaceMiejscowosc.isEmpty()){
                            text = text.replace(searchText10, ".....................................");
                            run.setText(text, 0);
                        }else {
                            text = text.replace(searchText10, replaceKodPocztowy + " " + replaceMiejscowosc);
                            run.setText(text, 0);
                        }
                    } else if (text != null && text.contains(searchText11)) {
                        text = text.replace(searchText11, replaceUlicaNumer.isEmpty() ? "....................................." : replaceUlicaNumer);
                        run.setText(text, 0);
                    } else if (text != null && text.contains(searchText12)) {
                        text = text.replace(searchText12, replaceSeriaDowodu.isEmpty() ? "....................................." : replaceSeriaDowodu);
                        run.setText(text, 0);
                    } else if (text != null && text.contains(searchText13)) {
                        text = text.replace(searchText13, replaceNrDowodu.isEmpty() ? "....................................." : replaceNrDowodu);
                        run.setText(text, 0);
                    } else if (text != null && text.contains(searchText2)) {
                        text = text.replace(searchText2, replaceNrRejPoszkodowanego.isEmpty() ? "....................................." : replaceNrRejPoszkodowanego);
                        run.setText(text, 0);
                    } else if (text != null && text.contains(searchText3)) {
                        text = text.replace(searchText3, replaceZuSprawcy.isEmpty() ? "...................................................................................................................................................." : replaceZuSprawcy);
                        run.setText(text, 0);
                    } else if (text != null && text.contains(searchText4)) {
                        text = text.replace(searchText4, replacePolisaOC.isEmpty() ? "....................................." : replacePolisaOC);
                        run.setText(text, 0);
                    } else if (text != null && text.contains(searchText20)) {
                        text = text.replace(searchText20, replaceNrRejSprawcy.isEmpty() ? "....................................." : replaceNrRejSprawcy);
                        run.setText(text, 0);
                    }
                }
            }

            File file = new File(System.getProperty("user.home"), "/Desktop/Pliki generatora/Cesja wierzytelności naprawa.docx");
            FileOutputStream out = new FileOutputStream(file);
            document.write(out);
            out.close();
            document.close();
            Desktop.getDesktop().open(file);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void savePelnomocnictwo(String replaceImieNazwiskoPoszkodowanego,
                                          String replaceMiejscowosc, String replaceKodPocztowy,
                                          String replaceUlicaNumer, String replaceSeriaDowodu,
                                          String replaceNrDowodu, String replacePojazdPoszkodowanego,
                                          String replaceNrRejPoszkodowanego, String replaceZuSprawcy,
                                          String replacePolisaOC, String replaceNrRejSprawcy,
                                          String replaceNrSzkody, DatePicker replaceDataZawarcia, String replaceMiejsceUmowy) {
        try {
            XWPFDocument document = new XWPFDocument(new FileInputStream(System.getProperty("user.home") + "/Desktop/Pliki generatora/Pliki źródłowe-NIE RUSZAĆ/PEŁNOMOCNICTWO GŁÓWNE.docx"));

            for (XWPFParagraph paragraph : document.getParagraphs()) {
                for (XWPFRun run : paragraph.getRuns()) {
                    String text = run.getText(0);
                    if (text != null && text.contains(searchText9)) {
                        text = text.replace(searchText9, replaceImieNazwiskoPoszkodowanego.isEmpty() ? "....................................." : replaceImieNazwiskoPoszkodowanego);
                        run.setText(text, 0);
                    } else if (text != null && text.contains(searchText10)) {
                        if(replaceKodPocztowy.isEmpty() && replaceMiejscowosc.isEmpty()){
                            text = text.replace(searchText10, ".....................................");
                            run.setText(text, 0);
                        }else {
                            text = text.replace(searchText10, replaceKodPocztowy + " " + replaceMiejscowosc);
                            run.setText(text, 0);
                        }
                    } else if (text != null && text.contains(searchText11)) {
                        text = text.replace(searchText11, replaceUlicaNumer.isEmpty() ? "....................................." : replaceUlicaNumer);
                        run.setText(text, 0);
                    } else if (text != null && text.contains(searchText12)) {
                        text = text.replace(searchText12, replaceSeriaDowodu.isEmpty() ? "....................................." : replaceSeriaDowodu);
                        run.setText(text, 0);
                    } else if (text != null && text.contains(searchText13)) {
                        text = text.replace(searchText13, replaceNrDowodu.isEmpty() ? "....................................." : replaceNrDowodu);
                        run.setText(text, 0);
                    } else if (text != null && text.contains(searchText2)) {
                        text = text.replace(searchText2, replaceNrRejPoszkodowanego.isEmpty() ? "....................................." : replaceNrRejPoszkodowanego);
                        run.setText(text, 0);
                    } else if (text != null && text.contains(searchText3)) {
                        String replaceText = replaceZuSprawcy != null ? replaceZuSprawcy : ".....................................";
                        text = text.replace(searchText3, replaceText);
                        run.setText(text, 0);
                    } else if (text != null && text.contains(searchText4)) {
                        text = text.replace(searchText4, replacePolisaOC.isEmpty() ? "....................................." : replacePolisaOC);
                        run.setText(text, 0);
                    } else if (text != null && text.contains(searchText20)) {
                        text = text.replace(searchText20, replaceNrRejSprawcy.isEmpty() ? "....................................." : replaceNrRejSprawcy);
                        run.setText(text, 0);
                    } else if (text != null && text.contains(searchText1)) {
                        text = text.replace(searchText1, replacePojazdPoszkodowanego.isEmpty() ? "....................................." : replacePojazdPoszkodowanego);
                        run.setText(text, 0);
                    } else if (text != null && text.contains(searchText21)) {
                        text = text.replace(searchText21, replaceNrSzkody.isEmpty() ? "....................................." : replaceNrSzkody);
                        run.setText(text, 0);
                    } else if (text != null && text.contains(searchText6)) {
                        text = text.replace(searchText6, replaceMiejsceUmowy.isEmpty() ? "....................................." : replaceMiejsceUmowy);
                        run.setText(text, 0);
                    } else if (text != null && text.contains(searchText5)) {
                        if (replaceDataZawarcia.getValue() != null) {
                            text = text.replace(searchText5, replaceDataZawarcia.getValue().format(DateTimeFormatter.ofPattern("dd.MM.yyyy")));
                            run.setText(text, 0);
                        } else {
                            text = text.replace(searchText5, ".....................................");
                            run.setText(text, 0);
                        }
                    }
                }
            }

            File file = new File(System.getProperty("user.home"), "/Desktop/Pliki generatora/Pełnomocnictwo główne.docx");
            FileOutputStream out = new FileOutputStream(file);
            document.write(out);
            out.close();
            document.close();
            Desktop.getDesktop().open(file);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void saveProtokol(DatePicker replaceDataZawarcia, String replaceWynajmowanyPojazd,
                                    String replaceNrRejWynajmowanegoPojazdu, String replaceNrRejSprawcy,
                                    String replacePojazdPoszkodowanego, String replaceMiejsceZdarzenia,
                                    String replaceImieNazwiskoPoszkodowanego, String replaceTelefonPoszkodowanego,
                                    String replaceMailPoszkodowanego) {
        try {
            XWPFDocument document = new XWPFDocument(new FileInputStream(System.getProperty("user.home") + "/Desktop/Pliki generatora/Pliki źródłowe-NIE RUSZAĆ/PROTOKÓŁ ZDAW-ODB OSOBOWE.docx"));

            for (XWPFParagraph paragraph : document.getParagraphs()) {
                for (XWPFRun run : paragraph.getRuns()) {
                    String text = run.getText(0);
                    if (text != null && text.contains(searchText5)) {
                        if (replaceDataZawarcia.getValue() != null) {
                            text = text.replace(searchText5, replaceDataZawarcia.getValue().format(DateTimeFormatter.ofPattern("dd.MM.yyyy")));
                            run.setText(text, 0);
                        } else {
                            text = text.replace(searchText5, ".....................................");
                            run.setText(text, 0);
                        }
                    } else if (text != null && text.contains(searchText20)) {
                        text = text.replace(searchText20, replaceNrRejSprawcy.isEmpty() ? "....................................." : replaceNrRejSprawcy);
                        run.setText(text, 0);
                    } else if (text != null && text.contains(searchText14)) {
                        text = text.replace(searchText14, replaceWynajmowanyPojazd.isEmpty() ? "....................................." : replaceWynajmowanyPojazd);
                        run.setText(text, 0);
                    } else if (text != null && text.contains(searchText15)) {
                        String replaceText2 = replaceNrRejWynajmowanegoPojazdu != null ? replaceNrRejWynajmowanegoPojazdu : ".....................................";
                        text = text.replace(searchText15, replaceText2);
                        run.setText(text, 0);
                    } else if (text != null && text.contains(searchText1)) {
                        text = text.replace(searchText1, replacePojazdPoszkodowanego.isEmpty() ? "....................................." : replacePojazdPoszkodowanego);
                        run.setText(text, 0);
                    } else if (text != null && text.contains(searchText22)) {
                        text = text.replace(searchText22, replaceMiejsceZdarzenia.isEmpty() ? "....................................." : replaceMiejsceZdarzenia);
                        run.setText(text, 0);
                    } else if (text != null && text.contains(searchText9)) {
                        text = text.replace(searchText9, replaceImieNazwiskoPoszkodowanego.isEmpty() ? "....................................." : replaceImieNazwiskoPoszkodowanego);
                        run.setText(text, 0);
                    } else if (text != null && text.contains(searchText23)) {
                        text = text.replace(searchText23, replaceTelefonPoszkodowanego.isEmpty() ? "....................................." : replaceTelefonPoszkodowanego);
                        run.setText(text, 0);
                    } else if (text != null && text.contains(searchText24)) {
                        text = text.replace(searchText24, replaceMailPoszkodowanego.isEmpty() ? "....................................." : replaceMailPoszkodowanego);
                        run.setText(text, 0);
                    }
                }
            }
            File file = new File(System.getProperty("user.home"), "/Desktop/Pliki generatora/Protokół zdaw-odb.docx");
            FileOutputStream out = new FileOutputStream(file);
            document.write(out);
            out.close();
            document.close();
            Desktop.getDesktop().open(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void savePotwierdzenieZwrotu(String replaceZuSprawcy, String replaceNrSzkody,
                                               DatePicker replaceDataZawarcia, String replaceMiejscowosc,
                                               String replaceSpolka, String replaceNip,
                                               String replaceImieNazwiskoPoszkodowanego, String replaceKodPocztowy,
                                               String replaceUlicaNumer, String replaceSeriaDowodu,
                                               String replaceNrDowodu, String replaceWynajmowanyPojazd,
                                               String replaceNrRejWynajmowanegoPojazdu, DatePicker replaceDataZwrotu) {
        try {
            XWPFDocument document = new XWPFDocument(new FileInputStream(System.getProperty("user.home") + "/Desktop/Pliki generatora/Pliki źródłowe-NIE RUSZAĆ/POTWIERDZENIE ZWROTU.docx"));

            for (XWPFParagraph paragraph : document.getParagraphs()) {
                for (XWPFRun run : paragraph.getRuns()) {
                    String text = run.getText(0);
                    if  (text != null && text.contains(searchText3)) {
                        String replaceText = replaceZuSprawcy != null ? replaceZuSprawcy : ".....................................";
                        text = text.replace(searchText3, replaceText);
                        run.setText(text, 0);
                    } else if (text != null && text.contains(searchText21)) {
                        text = text.replace(searchText21, replaceNrSzkody.isEmpty() ? "............................" : replaceNrSzkody);
                        run.setText(text, 0);
                    } else if (text != null && text.contains(searchText5)) {
                        if (replaceDataZawarcia.getValue() != null) {
                            text = text.replace(searchText5, replaceDataZawarcia.getValue().format(DateTimeFormatter.ofPattern("dd.MM.yyyy")));
                            run.setText(text, 0);
                        } else {
                            text = text.replace(searchText5, ".....................................");
                            run.setText(text, 0);
                        }
                    } else if (text != null && text.contains(searchText7)) {
                        text = text.replace(searchText7, replaceSpolka.isEmpty() ? "....................................." : replaceSpolka);
                        run.setText(text, 0);
                    } else if (text != null && text.contains(searchText8)) {
                        text = text.replace(searchText8, replaceNip.isEmpty() ? "....................................." : replaceNip);
                        run.setText(text, 0);
                    } else if (text != null && text.contains(searchText9)) {
                        text = text.replace(searchText9, replaceImieNazwiskoPoszkodowanego.isEmpty() ? "....................................." : replaceImieNazwiskoPoszkodowanego);
                        run.setText(text, 0);
                    } else if (text != null && text.contains(searchText10)) {
                        if(replaceKodPocztowy.isEmpty() && replaceMiejscowosc.isEmpty()){
                            text = text.replace(searchText10, ".....................................");
                            run.setText(text, 0);
                        }else {
                            text = text.replace(searchText10, replaceKodPocztowy + " " + replaceMiejscowosc);
                            run.setText(text, 0);
                        }
                    } else if (text != null && text.contains(searchText11)) {
                        text = text.replace(searchText11, replaceUlicaNumer.isEmpty() ? "....................................." : replaceUlicaNumer);
                        run.setText(text, 0);
                    } else if (text != null && text.contains(searchText12)) {
                        text = text.replace(searchText12, replaceSeriaDowodu.isEmpty() ? "....................................." : replaceSeriaDowodu);
                        run.setText(text, 0);
                    } else if (text != null && text.contains(searchText13)) {
                        text = text.replace(searchText13, replaceNrDowodu.isEmpty() ? "....................................." : replaceNrDowodu);
                        run.setText(text, 0);
                    } else if (text != null && text.contains(searchText14)) {
                        text = text.replace(searchText14, replaceWynajmowanyPojazd.isEmpty() ? "....................................." : replaceWynajmowanyPojazd);
                        run.setText(text, 0);
                    } else if (text != null && text.contains(searchText15)) {
                        String replaceText2 = replaceNrRejWynajmowanegoPojazdu != null ? replaceNrRejWynajmowanegoPojazdu : ".....................................";
                        text = text.replace(searchText15, replaceText2);
                        run.setText(text, 0);
                    } else if (text != null && text.contains(searchText25)) {
                        if (replaceDataZwrotu.getValue() != null) {
                            text = text.replace(searchText25, replaceDataZwrotu.getValue().format(DateTimeFormatter.ofPattern("dd.MM.yyyy")));
                            run.setText(text, 0);
                        } else {
                            text = text.replace(searchText25, ".....................................");
                            run.setText(text, 0);
                        }
                    }
                }
            }

            File file = new File(System.getProperty("user.home"), "/Desktop/Pliki generatora/Potwierdzenie zwrotu.docx");
            FileOutputStream out = new FileOutputStream(file);
            document.write(out);
            out.close();
            document.close();
            Desktop.getDesktop().open(file);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void saveOswiadczenieOPotrzebieAZ(String replaceMiejsceUmowy, String replaceMiejscowosc,
                                                    String replaceImieNazwiskoPoszkodowanego, String replaceKodPocztowy,
                                                    String replaceUlicaNumer, String replaceZuSprawcy, String replaceNrSzkody,
                                                    String replaceWynajmowanyPojazd, String replaceNrRejWynajmowanegoPojazdu,
                                                    DatePicker replaceDataZawarcia) {
        try {
            XWPFDocument document = new XWPFDocument(new FileInputStream(System.getProperty("user.home") + "/Desktop/Pliki generatora/Pliki źródłowe-NIE RUSZAĆ/OŚWIADCZENIE O POTRZEBIE AUTA ZASTĘPCZEGO.docx"));

            for (XWPFParagraph paragraph : document.getParagraphs()) {
                for (XWPFRun run : paragraph.getRuns()) {
                    String text = run.getText(0);
                    if (text != null && text.contains(searchText6)) {
                        text = text.replace(searchText6, replaceMiejsceUmowy.isEmpty() ? "....................................." : replaceMiejsceUmowy);
                        run.setText(text, 0);
                    } else if (text != null && text.contains(searchText5)) {
                        if (replaceDataZawarcia.getValue() != null) {
                            text = text.replace(searchText5, replaceDataZawarcia.getValue().format(DateTimeFormatter.ofPattern("dd.MM.yyyy")));
                            run.setText(text, 0);
                        } else {
                            text = text.replace(searchText5, ".....................................");
                            run.setText(text, 0);
                        }
                    } else if (text != null && text.contains(searchText9)) {
                        text = text.replace(searchText9, replaceImieNazwiskoPoszkodowanego.isEmpty() ? "....................................." : replaceImieNazwiskoPoszkodowanego);
                        run.setText(text, 0);
                    } else if (text != null && text.contains(searchText10)) {
                        if(replaceKodPocztowy.isEmpty() && replaceMiejscowosc.isEmpty()){
                            text = text.replace(searchText10, ".....................................");
                            run.setText(text, 0);
                        }else {
                            text = text.replace(searchText10, replaceKodPocztowy + " " + replaceMiejscowosc);
                            run.setText(text, 0);
                        }
                    } else if (text != null && text.contains(searchText11)) {
                        text = text.replace(searchText11, replaceUlicaNumer.isEmpty() ? "....................................." : replaceUlicaNumer);
                        run.setText(text, 0);
                    } else if (text != null && text.contains(searchText14)) {
                        text = text.replace(searchText14, replaceWynajmowanyPojazd.isEmpty() ? "....................................." : replaceWynajmowanyPojazd);
                        run.setText(text, 0);
                    } else if (text != null && text.contains(searchText15)) {
                        String replaceText2 = replaceNrRejWynajmowanegoPojazdu != null ? replaceNrRejWynajmowanegoPojazdu : ".....................................";
                        text = text.replace(searchText15, replaceText2);
                        run.setText(text, 0);
                    } else if (text != null && text.contains(searchText3)) {
                        String replaceText = replaceZuSprawcy != null ? replaceZuSprawcy : ".....................................";
                        text = text.replace(searchText3, replaceText);
                        run.setText(text, 0);
                    } else if (text != null && text.contains(searchText21)) {
                        text = text.replace(searchText21, replaceNrSzkody.isEmpty() ? "............................" : replaceNrSzkody);
                        run.setText(text, 0);
                    } else if (text != null && text.contains(searchText26)) {
                        text = text.replace(searchText26, currentDate.format(DateTimeFormatter.ofPattern("dd.MM.yyyy")) + "r.");
                        run.setText(text, 0);
                    }
                }
            }

            File file = new File(System.getProperty("user.home"), "/Desktop/Pliki generatora/Oświadczenie o potrzebie AZ.docx");
            FileOutputStream out = new FileOutputStream(file);
            document.write(out);
            out.close();
            document.close();
            Desktop.getDesktop().open(file);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
