/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package misServicios;

import com.aspose.pdf.Document;
import com.aspose.pdf.HtmlFragment;
import com.aspose.pdf.Page;
import com.aspose.pdf.TextFragment;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import java.util.*;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.*;
import javax.mail.Session;
import javax.mail.Transport;

/**
 *
 * @author ecarr
 */
@WebService(serviceName = "CorreoWS")
public class CorreoWS {

    /**
     * This is a sample web service operation
     *
     * @param destinatario
     * @return
     */
    @WebMethod(operationName = "enviarCorreo")
    public void enviarCorreo(@WebParam(name = "destinatario") String destinatario, @WebParam(name = "fecha") String fecha, @WebParam(name = "hora") String hora, @WebParam(name = "motivo") String motivo, @WebParam(name = "importeFactura") int importeFactura) {

        Document document = new Document();
        String nombre = generarPdf(document, fecha, hora, motivo, importeFactura);
        Path currentRelativePath = Paths.get("");
        String s = currentRelativePath.toAbsolutePath().toString() + "\\" + nombre;
        System.out.println(s);
        
        Date fechaActual = new Date();
        SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String fechaFormateada = formatoFecha.format(fechaActual);

        String remitente = "clinicasupovet@gmail.com";
        String claveemail = "adxo uvxk xtql kfsc";

        String contenido = "<!DOCTYPE html>\n"
                + "<html>\n"
                + "<head>\n"
                + "<style>\n"
                + "  .cita {\n"
                + "    border-left: 6px solid #4CAF50;\n"
                + "    background-color: #f2f2f2;\n"
                + "    padding: 10px;\n"
                + "    margin: 20px 0;\n"
                + "  }\n"
                + "</style>\n"
                + "</head>\n"
                + "<body>\n"
                + "<div class=\"cita\">\n"
                + "  <p><strong>Fecha:</strong> " + fecha + "</p>\n"
                + "  <p><strong>Hora:</strong> " + hora + "</p>\n"
                + "  <p><strong>Motivo:</strong> " + motivo + "</p>\n"
                + "</div>\n"
                + "</body>\n"
                + "</html>";

        Properties props = System.getProperties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.user", remitente);
        props.put("mail.smtp.clave", claveemail);
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.port", "587");

        Session session = Session.getDefaultInstance(props);
        MimeMessage message = new MimeMessage(session);

        try {
            message.setFrom(new InternetAddress(remitente));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(destinatario));
            message.setSubject("Nueva Cita UPOVET - " + fechaFormateada);

            // Crea el cuerpo del correo
            MimeBodyPart mensajeBodyPart = new MimeBodyPart();
            mensajeBodyPart.setText(contenido, "utf-8", "html");

            // Adjunta el archivo PDF
            MimeBodyPart adjuntoBodyPart = new MimeBodyPart();
            DataSource fuenteDatos = new FileDataSource(s);
            adjuntoBodyPart.setDataHandler(new DataHandler(fuenteDatos));
            adjuntoBodyPart.setFileName(nombre);

            // Une el cuerpo del mensaje y el archivo adjunto
            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(mensajeBodyPart);
            multipart.addBodyPart(adjuntoBodyPart);

            message.setContent(multipart);

            // Envía el correo electrónico
            Transport transport = session.getTransport("smtp");
            transport.connect("smtp.gmail.com", remitente, claveemail);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();

        } catch (MessagingException me) {
            me.printStackTrace();
        }

    }

    private static String generarPdf(Document doc, String fecha, String hora, String motivo, int importeFactura) {
        
        Date fechaActual = new Date();
        SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyyMMddHHmmss");
        String fechaFormateada = formatoFecha.format(fechaActual);
        String nombre = "cita_" + fechaFormateada + ".pdf";

        HtmlFragment t = new HtmlFragment("<body style='line-height: 100px;'><ul><li>Fecha de la cita: "+ fecha +"</li><li>Hora de la fecha: "+hora+"</li><li>Motivo de la cita: "+motivo+"</li></ul>Importe a pagar por esta cita <strong>"+importeFactura+"</strong>></body>");

        Page page = doc.getPages().add();

        page.getParagraphs().add(t);

        doc.save(nombre);
        return nombre;
    }

}
