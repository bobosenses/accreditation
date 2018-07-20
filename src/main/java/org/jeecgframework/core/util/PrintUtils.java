//package org.jeecgframework.core.util;
//
//
//import java.io.FileInputStream;
//import java.io.IOException;
//
//import javax.print.Doc;
//import javax.print.DocFlavor;
//import javax.print.DocPrintJob;
//import javax.print.PrintException;
//import javax.print.PrintService;
//import javax.print.PrintServiceLookup;
//import javax.print.SimpleDoc;
//import javax.print.attribute.DocAttributeSet;
//import javax.print.attribute.HashDocAttributeSet;
//import javax.print.attribute.HashPrintRequestAttributeSet;
//import javax.print.attribute.PrintRequestAttributeSet;
//import javax.print.attribute.standard.Copies;
//import javax.print.attribute.standard.MediaPrintableArea;
//import javax.print.attribute.standard.OrientationRequested;
//import javax.print.attribute.standard.PrintQuality;
//
//public class PrintUtils {
//    public static String drawImage(String fileName, int count) {
//        try {
//            DocFlavor dof = null;
//            if (fileName.endsWith(".gif")) {
//                dof = DocFlavor.INPUT_STREAM.GIF;
//            } else if (fileName.endsWith(".jpg")) {
//                dof = DocFlavor.INPUT_STREAM.JPEG;
//            } else if (fileName.endsWith(".png")) {
//                dof = DocFlavor.INPUT_STREAM.PNG;
//            }
//
//            PrintService ps = PrintServiceLookup.lookupDefaultPrintService();
//            PrintRequestAttributeSet pras = new HashPrintRequestAttributeSet();
//            pras.add(OrientationRequested.LANDSCAPE);
//
//            pras.add(new Copies(count));
//            pras.add(PrintQuality.HIGH);
//            DocAttributeSet das = new HashDocAttributeSet();
//
//            // 设置打印纸张的大小（以毫米为单位）85   54
//            das.add(new MediaPrintableArea(0, 0, 180, 112, MediaPrintableArea.MM));
//            FileInputStream fin = new FileInputStream(fileName);
//
//            Doc doc = new SimpleDoc(fin, dof, das);
//
//            DocPrintJob job = ps.createPrintJob();
//
//            job.print(doc, pras);
//            fin.close();
//        } catch (IOException ie) {
//            ie.printStackTrace();
//            return "fail";
//        } catch (PrintException pe) {
//            pe.printStackTrace();
//            return "fail";
//        }
//        return "success";
//    }
//
//    public static void main(String[] args){
////        new PrintUtils().drawImage("E:\\张志军_140113197408182312_print.jpg", 1);
////        Thread.currentThread().sleep(1000);
////        new PrintUtils().drawImage("E:\\赵臣_140113197912292334_print.jpg", 1);
////        new PrintUtils().drawImage("E:\\王晓林_140113198106282312_print.jpg", 1);
//    }
//}
