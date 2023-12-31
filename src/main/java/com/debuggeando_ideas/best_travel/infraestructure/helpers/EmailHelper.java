package com.debuggeando_ideas.best_travel.infraestructure.helpers;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
@Slf4j
public class EmailHelper {

    private final JavaMailSender mailSender ;

    public void sendMail(String to, String name, String product) {
        try {
            MimeMessage message = mailSender.createMimeMessage();
            String htmlContent = this.readHTMLTemplate(name, product);
            message.setFrom(new InternetAddress(("theemanuel211@gmail.com")));
            message.setRecipients(MimeMessage.RecipientType.TO, to);
            message.setSubject("Su compra ha sido confirmada");
            message.setContent(htmlContent, MediaType.TEXT_HTML_VALUE);
            mailSender.send(message);
        } catch (MessagingException e) {
            log.error("Error to send mail", e);
        }
    }

    private String readHTMLTemplate(String name, String product) {
        //try(var lines = Files.lines(TEMPLATE_PATH)) {
        try {
            //var html = lines.collect(Collectors.joining());
            String emailContent = "<!doctype html>\n" +
                    "<html>\n" +
                    "<head>\n" +
                    "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\"/>\n" +
                    "    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" />\n" +
                    "    <title>Simple Transactional Email</title>\n" +
                    "    <style>\n" +
                    "                img {\n" + 
                    "            border: none;\n" + 
                    "            -ms-interpolation-mode: bicubic;\n" + 
                    "            max-width: 100%;\n" + 
                    "        }\n" + 
                    "\n" + 
                    "        body {\n" + 
                    "            background-color: #f6f6f6;\n" + 
                    "            font-family: sans-serif;\n" + 
                    "            -webkit-font-smoothing: antialiased;\n" + 
                    "            font-size: 14px;\n" + 
                    "            line-height: 1.4;\n" + 
                    "            margin: 0;\n" + 
                    "            padding: 0;\n" + 
                    "            -ms-text-size-adjust: 100%;\n" + 
                    "            -webkit-text-size-adjust: 100%;\n" + 
                    "        }\n" + 
                    "\n" + 
                    "        table {\n" + 
                    "            border-collapse: separate;\n" + 
                    "            mso-table-lspace: 0pt;\n" + 
                    "            mso-table-rspace: 0pt;\n" + 
                    "            width: 100%; }\n" + 
                    "        table td {\n" + 
                    "            font-family: sans-serif;\n" + 
                    "            font-size: 14px;\n" + 
                    "            vertical-align: top;\n" + 
                    "        }\n" + 
                    "\n" + 
                    "        .body {\n" + 
                    "            background-color: #f6f6f6;\n" + 
                    "            width: 100%;\n" + 
                    "        }\n" + 
                    "        .container {\n" + 
                    "            display: block;\n" + 
                    "            margin: 0 auto !important;\n" + 
                    "            max-width: 580px;\n" + 
                    "            padding: 10px;\n" + 
                    "            width: 580px;\n" + 
                    "        }\n" + 
                    "\n" + 
                    "        .content {\n" + 
                    "            box-sizing: border-box;\n" + 
                    "            display: block;\n" + 
                    "            margin: 0 auto;\n" + 
                    "            max-width: 580px;\n" + 
                    "            padding: 10px;\n" + 
                    "        }\n" + 
                    "\n" + 
                    "        .main {\n" + 
                    "            background: #ffffff;\n" + 
                    "            border-radius: 3px;\n" + 
                    "            width: 100%;\n" + 
                    "        }\n" + 
                    "\n" + 
                    "        .wrapper {\n" + 
                    "            box-sizing: border-box;\n" + 
                    "            padding: 20px;\n" + 
                    "        }\n" + 
                    "\n" + 
                    "        .content-block {\n" + 
                    "            padding-bottom: 10px;\n" + 
                    "            padding-top: 10px;\n" + 
                    "        }\n" + 
                    "\n" + 
                    "        .footer {\n" + 
                    "            clear: both;\n" + 
                    "            margin-top: 10px;\n" + 
                    "            text-align: center;\n" + 
                    "            width: 100%;\n" + 
                    "            background-color: mediumpurple;\n" + 
                    "        }\n" + 
                    "        .footer td,\n" + 
                    "        .footer p,\n" + 
                    "        .footer span,\n" + 
                    "        .footer a {\n" + 
                    "            font-size: 12px;\n" + 
                    "            text-align: center;\n" + 
                    "        }\n" + 
                    "\n" + 
                    "        h1,\n" + 
                    "        h2,\n" + 
                    "        h3,\n" + 
                    "        h4 {\n" + 
                    "            color: #000000;\n" + 
                    "            font-family: sans-serif;\n" + 
                    "            font-weight: 400;\n" + 
                    "            line-height: 1.4;\n" + 
                    "            margin: 0;\n" + 
                    "            margin-bottom: 30px;\n" + 
                    "        }\n" + 
                    "\n" + 
                    "        h1 {\n" + 
                    "            font-size: 35px;\n" + 
                    "            font-weight: 300;\n" + 
                    "            text-align: center;\n" + 
                    "            text-transform: capitalize;\n" + 
                    "        }\n" + 
                    "\n" + 
                    "        p,\n" + 
                    "        ul,\n" + 
                    "        ol {\n" + 
                    "            font-family: sans-serif;\n" + 
                    "            font-size: 14px;\n" + 
                    "            font-weight: normal;\n" + 
                    "            margin: 0;\n" + 
                    "            margin-bottom: 15px;\n" + 
                    "        }\n" + 
                    "        p li,\n" + 
                    "        ul li,\n" + 
                    "        ol li {\n" + 
                    "            list-style-position: inside;\n" + 
                    "            margin-left: 5px;\n" + 
                    "        }\n" + 
                    "\n" + 
                    "        a {\n" + 
                    "            color: #3498db;\n" + 
                    "            text-decoration: underline;\n" + 
                    "        }\n" + 
                    "\n" + 
                    "        .btn {\n" + 
                    "            box-sizing: border-box;\n" + 
                    "            width: 100%; }\n" + 
                    "        .btn > tbody > tr > td {\n" + 
                    "            padding-bottom: 15px; }\n" + 
                    "        .btn table {\n" + 
                    "            width: auto;\n" + 
                    "        }\n" + 
                    "        .btn table td {\n" + 
                    "            background-color: #ffffff;\n" + 
                    "            border-radius: 5px;\n" + 
                    "            text-align: center;\n" + 
                    "        }\n" + 
                    "        .btn a {\n" + 
                    "            background-color: #ffffff;\n" + 
                    "            border: solid 1px #3498db;\n" + 
                    "            border-radius: 5px;\n" + 
                    "            box-sizing: border-box;\n" + 
                    "            color: #3498db;\n" + 
                    "            cursor: pointer;\n" + 
                    "            display: inline-block;\n" + 
                    "            font-size: 14px;\n" + 
                    "            font-weight: bold;\n" + 
                    "            margin: 0;\n" + 
                    "            padding: 12px 25px;\n" + 
                    "            text-decoration: none;\n" + 
                    "            text-transform: capitalize;\n" + 
                    "        }\n" + 
                    "\n" + 
                    "        .btn-primary table td {\n" + 
                    "            background-color: #3498db;\n" + 
                    "        }\n" + 
                    "\n" + 
                    "        .btn-primary a {\n" + 
                    "            background-color: #3498db;\n" + 
                    "            border-color: #3498db;\n" + 
                    "            color: #ffffff;\n" + 
                    "        }\n" + 
                    "\n" + 
                    "        /* -------------------------------------\n" + 
                    "            OTHER STYLES THAT MIGHT BE USEFUL\n" + 
                    "        ------------------------------------- */\n" + 
                    "        .last {\n" + 
                    "            margin-bottom: 0;\n" + 
                    "        }\n" + 
                    "\n" + 
                    "        .first {\n" + 
                    "            margin-top: 0;\n" + 
                    "        }\n" + 
                    "\n" + 
                    "        .align-center {\n" + 
                    "            text-align: center;\n" + 
                    "        }\n" + 
                    "\n" + 
                    "        .align-right {\n" + 
                    "            text-align: right;\n" + 
                    "        }\n" + 
                    "\n" + 
                    "        .align-left {\n" + 
                    "            text-align: left;\n" + 
                    "        }\n" + 
                    "\n" + 
                    "        .clear {\n" + 
                    "            clear: both;\n" + 
                    "        }\n" + 
                    "\n" + 
                    "        .mt0 {\n" + 
                    "            margin-top: 0;\n" + 
                    "        }\n" + 
                    "\n" + 
                    "        .mb0 {\n" + 
                    "            margin-bottom: 0;\n" + 
                    "        }\n" + 
                    "\n" + 
                    "        .preheader {\n" + 
                    "            color: transparent;\n" + 
                    "            display: none;\n" + 
                    "            height: 0;\n" + 
                    "            max-height: 0;\n" + 
                    "            max-width: 0;\n" + 
                    "            opacity: 0;\n" + 
                    "            overflow: hidden;\n" + 
                    "            mso-hide: all;\n" + 
                    "            visibility: hidden;\n" + 
                    "            width: 0;\n" + 
                    "        }\n" + 
                    "\n" + 
                    "        .powered-by a {\n" + 
                    "            text-decoration: none;\n" + 
                    "        }\n" + 
                    "\n" + 
                    "        hr {\n" + 
                    "            border: 0;\n" + 
                    "            border-bottom: 1px solid #f6f6f6;\n" + 
                    "            margin: 20px 0;\n" + 
                    "        }\n" + 
                    "\n" + 
                    "        @media only screen and (max-width: 620px) {\n" + 
                    "            table.body h1 {\n" + 
                    "                font-size: 28px !important;\n" + 
                    "                margin-bottom: 10px !important;\n" + 
                    "            }\n" + 
                    "            table.body p,\n" + 
                    "            table.body ul,\n" + 
                    "            table.body ol,\n" + 
                    "            table.body td,\n" + 
                    "            table.body span,\n" + 
                    "            table.body a {\n" + 
                    "                font-size: 16px !important;\n" + 
                    "            }\n" + 
                    "            table.body .wrapper,\n" + 
                    "            table.body .article {\n" + 
                    "                padding: 10px !important;\n" + 
                    "            }\n" + 
                    "            table.body .content {\n" + 
                    "                padding: 0 !important;\n" + 
                    "            }\n" + 
                    "            table.body .container {\n" + 
                    "                padding: 0 !important;\n" + 
                    "                width: 100% !important;\n" + 
                    "            }\n" + 
                    "            table.body .main {\n" + 
                    "                border-left-width: 0 !important;\n" + 
                    "                border-radius: 0 !important;\n" + 
                    "                border-right-width: 0 !important;\n" + 
                    "            }\n" + 
                    "            table.body .btn table {\n" + 
                    "                width: 100% !important;\n" + 
                    "            }\n" + 
                    "            table.body .btn a {\n" + 
                    "                width: 100% !important;\n" + 
                    "            }\n" + 
                    "            table.body .img-responsive {\n" + 
                    "                height: auto !important;\n" + 
                    "                max-width: 100% !important;\n" + 
                    "                width: auto !important;\n" + 
                    "            }\n" + 
                    "        }\n" + 
                    "\n" + 
                    "        @media all {\n" + 
                    "            .ExternalClass {\n" + 
                    "                width: 100%;\n" + 
                    "            }\n" + 
                    "            .ExternalClass,\n" + 
                    "            .ExternalClass p,\n" + 
                    "            .ExternalClass span,\n" + 
                    "            .ExternalClass font,\n" + 
                    "            .ExternalClass td,\n" + 
                    "            .ExternalClass div {\n" + 
                    "                line-height: 100%;\n" + 
                    "            }\n" + 
                    "            .apple-link a {\n" + 
                    "                color: inherit !important;\n" + 
                    "                font-family: inherit !important;\n" + 
                    "                font-size: inherit !important;\n" + 
                    "                font-weight: inherit !important;\n" + 
                    "                line-height: inherit !important;\n" + 
                    "                text-decoration: none !important;\n" + 
                    "            }\n" + 
                    "            #MessageViewBody a {\n" + 
                    "                color: inherit;\n" + 
                    "                text-decoration: none;\n" + 
                    "                font-size: inherit;\n" + 
                    "                font-family: inherit;\n" + 
                    "                font-weight: inherit;\n" + 
                    "                line-height: inherit;\n" + 
                    "            }\n" + 
                    "            .btn-primary table td:hover {\n" + 
                    "                background-color: #34495e !important;\n" + 
                    "            }\n" + 
                    "            .btn-primary a:hover {\n" + 
                    "                background-color: #34495e !important;\n" + 
                    "                border-color: #34495e !important;\n" + 
                    "            }\n" + 
                    "        }" +
                    "    </style>\n" +
                    "</head>\n" +
                    "<body>\n" +
                    "<span class=\"preheader\">This is preheader text. Some clients will show this text as a preview.</span>\n" +
                    "<table role=\"presentation\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"body\">\n" +
                    "        <tr>\n" + 
                    "        <td>&nbsp;</td>\n" + 
                    "        <td class=\"container\">\n" + 
                    "            <div class=\"content\">\n" + 
                    "\n" + 
                    "                <!-- START CENTERED WHITE CONTAINER -->\n" + 
                    "                <table role=\"presentation\" class=\"main\">\n" + 
                    "\n" + 
                    "                    <!-- START MAIN CONTENT AREA -->\n" + 
                    "                    <tr>\n" + 
                    "                        <td class=\"wrapper\">\n" + 
                    "                            <table role=\"presentation\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">\n" + 
                    "                                <tr>\n" + 
                    "                                    <td>\n" + 
                    "                                        <p>Hi {name} it is a pleasure to inform you thah:</p>\n" + 
                    "                                        <p>Your {product} has been registered</p>\n" + 
                    "                                        <table role=\"presentation\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"btn btn-primary\">\n" + 
                    "                                            <tbody>\n" + 
                    "                                            <tr>\n" + 
                    "                                                <td align=\"left\">\n" + 
                    "                                                    <table role=\"presentation\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">\n" + 
                    "                                                        <tbody>\n" + 
                    "                                                        <tr>\n" + 
                    "                                                            <td> <a href=\"https://www.linkedin.com/in/torresemma/\" target=\"_blank\">See more</a> </td>\n" + 
                    "                                                        </tr>\n" + 
                    "                                                        </tbody>\n" + 
                    "                                                    </table>\n" + 
                    "                                                </td>\n" + 
                    "                                            </tr>\n" + 
                    "                                            </tbody>\n" + 
                    "                                        </table>\n" + 
                    "                                        <p> Don't respond this email. </p>\n" + 
                    "                                    </td>\n" + 
                    "                                </tr>\n" + 
                    "                            </table>\n" + 
                    "                        </td>\n" + 
                    "                    </tr>\n" + 
                    "\n" + 
                    "                </table>\n" + 
                    "\n" + 
                    "                <div class=\"footer\">\n" + 
                    "                    <table role=\"presentation\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">\n" + 
                    "                        <tr>\n" + 
                    "                            <td class=\"content-block\">\n" + 
                    "                                <span class=\"apple-link\">Best travel 3 Abbey Road, San Francisco CP 94102</span>\n" + 
                    "                                <br> Best Travel the best way to travel.\n" + 
                    "                            </td>\n" + 
                    "                        </tr>\n" + 
                    "                        <tr>\n" + 
                    "                            <td class=\"content-block powered-by\">\n" + 
                    "                                Powered by <a style=\"color: white;\" href=\"https://www.linkedin.com/in/torresemma/\">The Best Travel Emmanuel</a>.\n" + 
                    "                            </td>\n" + 
                    "                        </tr>\n" + 
                    "                    </table>\n" + 
                    "                </div>\n" + 
                    "                <!-- END FOOTER -->\n" + 
                    "\n" + 
                    "            </div>\n" + 
                    "        </td>\n" + 
                    "        <td>&nbsp;</td>\n" + 
                    "    </tr>" +
                    "</table>\n" +
                    "</body>\n" +
                    "</html>";

            // Ahora puedes usar la cadena 'emailContent' para enviar el correo usando JavaMailSender

            
            return emailContent.replace("{name}", name).replace("{product}", product);
        } catch (Exception e) {
            log.error("Cant read html template", e);
            throw new RuntimeException();
        }
    }

    private final Path TEMPLATE_PATH = Paths.get("src/main/resources/email/email_template.html");

}
