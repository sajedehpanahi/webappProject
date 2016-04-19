package com.servlets;

public class OutPutGenerator {

    public String generate(String exception){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<!DOCTYPE html>");
        stringBuilder.append("<html lang=fa>");
        stringBuilder.append("<head>");
        stringBuilder.append("    <meta charset=UTF-8>");
        stringBuilder.append("    <link href=css/Style.css rel=stylesheet>");
        stringBuilder.append("    <title>خطا در ثبت اطلاعات مشتری</title>");
        stringBuilder.append("</head>");
        stringBuilder.append("<body>");
        stringBuilder.append("<div class=title>");
        stringBuilder.append("    <h1>خطا در ثبت اطلاعات مشتری</h1>");
        stringBuilder.append("</div>");
        stringBuilder.append("<div id=wrapper>");
        stringBuilder.append("    <div class=content>");
        stringBuilder.append("        <div class=box>");
        stringBuilder.append("            <div class=box-top></div>");
        stringBuilder.append("            <div class=box-in>");
        stringBuilder.append("                <br>");
        stringBuilder.append("                 <h2>خطا!</h2>");
        stringBuilder.append("                <br>");
        stringBuilder.append("                <p>" + exception + "</p>");
        stringBuilder.append("            </div>");
        stringBuilder.append("            <div class=box-bottom></div>");
        stringBuilder.append("        </div>");
        stringBuilder.append("        <div class=cleaner>&nbsp</div>");
        stringBuilder.append("    </div>");
        stringBuilder.append("</div>");
        stringBuilder.append("<div align=center>Sajedehpanahi@gmail.com</div>");
        stringBuilder.append("</body>");
        stringBuilder.append("</html>");
        return  stringBuilder.toString();
    }

    public String generate(String companyName, String dateOfRegistration, String economicCode,String customerNumber){

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<!DOCTYPE html>");
        stringBuilder.append("<html lang=fa>");
        stringBuilder.append("<head>");
        stringBuilder.append("    <meta charset=UTF-8>");
        stringBuilder.append("    <link href=css/Style.css rel=stylesheet>");
        stringBuilder.append("    <title>اطلاعات مشتری جدید</title>");
        stringBuilder.append("</head>");
        stringBuilder.append("<body>");
        stringBuilder.append("<div class=title>");
        stringBuilder.append("    <h1>اطلاعات مشتری جدید</h1>");
        stringBuilder.append("</div>");
        stringBuilder.append("<div id=wrapper>");
        stringBuilder.append("    <div class=content>");
        stringBuilder.append("        <div class=box>");
        stringBuilder.append("            <div class=box-top></div>");
        stringBuilder.append("            <div class=box-in>");
        stringBuilder.append("                <br>");
        stringBuilder.append("                <p>اطلاعات زیر برای مشتری جدید ثبت شد</p>");
        stringBuilder.append("                <br>");
        stringBuilder.append("                    <table>");
        stringBuilder.append("                        <tr>");
        stringBuilder.append("                            <td> نام شرکت </td>");
        stringBuilder.append("                            <td>"+companyName+"</td>");
        stringBuilder.append("                        </tr>");
        stringBuilder.append("                        <tr>");
        stringBuilder.append("                            <td> تاریخ ثبت</td>");
        stringBuilder.append("                            <td>"+dateOfRegistration+"</td>");
        stringBuilder.append("                        </tr>");
        stringBuilder.append("                        <tr>");
        stringBuilder.append("                            <td>کد اقتصادی</td>");
        stringBuilder.append("                            <td>"+economicCode+"</td>");
        stringBuilder.append("                        </tr>");
        stringBuilder.append("                        <tr>");
        stringBuilder.append("                            <td>شماره مشتری</td>");
        stringBuilder.append("                            <td>"+customerNumber+"</td>");
        stringBuilder.append("                        </tr>");
        stringBuilder.append("                    </table>");
        stringBuilder.append("                    <a href=legal-customer-management.html class=form>بازگشت به صفحه قبل</a>");
        stringBuilder.append("            </div>");
        stringBuilder.append("            <div class=box-bottom></div>");
        stringBuilder.append("        </div>");
        stringBuilder.append("        <div class=cleaner>&nbsp</div>");
        stringBuilder.append("    </div>");
        stringBuilder.append("</div>");
        stringBuilder.append("<div align=center>Sajedehpanahi@gmail.com</div>");
        stringBuilder.append("</body>");
        stringBuilder.append("</html>");

        return stringBuilder.toString();
    }

    public String generate(String firstName,String lastName, String fatherName, String dateOfBirth, String nationalCode, String customerNumber){

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<!DOCTYPE html>");
        stringBuilder.append("<html lang=fa>");
        stringBuilder.append("<head>");
        stringBuilder.append("    <meta charset=UTF-8>");
        stringBuilder.append("    <link href=css/Style.css rel=stylesheet>");
        stringBuilder.append("    <title>اطلاعات مشتری جدید</title>");
        stringBuilder.append("</head>");
        stringBuilder.append("<body>");
        stringBuilder.append("<div class=title>");
        stringBuilder.append("    <h1>اطلاعات مشتری جدید</h1>");
        stringBuilder.append("</div>");
        stringBuilder.append("<div id=wrapper>");
        stringBuilder.append("    <div class=content>");
        stringBuilder.append("        <div class=box>");
        stringBuilder.append("            <div class=box-top></div>");
        stringBuilder.append("            <div class=box-in>");
        stringBuilder.append("                <br>");
        stringBuilder.append("                <p>اطلاعات زیر برای مشتری جدید ثبت شد</p>");
        stringBuilder.append("                <br>");
        stringBuilder.append("                    <table>");
        stringBuilder.append("                        <tr>");
        stringBuilder.append("                            <td> نام </td>");
        stringBuilder.append("                            <td>"+firstName+"</td>");
        stringBuilder.append("                        </tr>");
        stringBuilder.append("                        <tr>");
        stringBuilder.append("                            <td> نام خانوادگی</td>");
        stringBuilder.append("                            <td>"+lastName+"</td>");
        stringBuilder.append("                        </tr>");
        stringBuilder.append("                        <tr>");
        stringBuilder.append("                            <td>نام پدر</td>");
        stringBuilder.append("                            <td>"+fatherName+"</td>");
        stringBuilder.append("                        </tr>");
        stringBuilder.append("                        <tr>");
        stringBuilder.append("                            <td>تاریخ تولد</td>");
        stringBuilder.append("                            <td>"+dateOfBirth+"</td>");
        stringBuilder.append("                        </tr>");
        stringBuilder.append("                        <tr>");
        stringBuilder.append("                            <td>کد ملی</td>");
        stringBuilder.append("                            <td>"+nationalCode+"</td>");
        stringBuilder.append("                        </tr>");
        stringBuilder.append("                        <tr>");
        stringBuilder.append("                            <td>شماره مشتری</td>");
        stringBuilder.append("                            <td>"+customerNumber+"</td>");
        stringBuilder.append("                        </tr>");
        stringBuilder.append("                    </table>");
        stringBuilder.append("                    <a href=legal-customer-management.html class=form>بازگشت به صفحه قبل</a>");
        stringBuilder.append("            </div>");
        stringBuilder.append("            <div class=box-bottom></div>");
        stringBuilder.append("        </div>");
        stringBuilder.append("        <div class=cleaner>&nbsp</div>");
        stringBuilder.append("    </div>");
        stringBuilder.append("</div>");
        stringBuilder.append("<div align=center>Sajedehpanahi@gmail.com</div>");
        stringBuilder.append("</body>");
        stringBuilder.append("</html>");

        return stringBuilder.toString();
    }
}
