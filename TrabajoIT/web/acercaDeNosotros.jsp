<%-- 
    Document   : acercaDeNosotros
    Created on : 29-may-2024, 13:37:48
    Author     : ecarr
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Acerca de Nosotros - UPOVET Sevilla</title>
        <style>
            .container {
                box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            }
            h1, h2, h3 {
                color: #2c3e50;
            }
            p {
                line-height: 1.6;
            }
        </style>
    </head>
    <body>
        <jsp:include page="HEADER.jsp" />
        <div class="container">
            <h1>Bienvenidos a UPOVET Sevilla</h1>
            <p>En UPOVET Sevilla, nos enorgullece ofrecer una atención veterinaria excepcional para tus mascotas. Ubicados en el corazón de Sevilla, nuestro equipo de profesionales está dedicado a proporcionar el mejor cuidado posible para tus compañeros animales, garantizando su salud y bienestar.</p>

            <h2>Nuestra Misión</h2>
            <p>Nuestra misión es proporcionar atención veterinaria de alta calidad con un enfoque en la compasión y la excelencia. Creemos que cada mascota merece un trato individualizado y personal, y trabajamos incansablemente para asegurarnos de que reciban el cuidado que necesitan y merecen.</p>

            <h2>Nuestro Equipo</h2>
            <div>
                <h3>Dr. Elena Carrasco - Directora Veterinaria</h3>
                <p>Con más de 15 años de experiencia en medicina veterinaria, la Dra. Elena Carrasco es una experta en diagnóstico y tratamiento de enfermedades animales. Su dedicación y amor por los animales la han convertido en una figura respetada en la comunidad veterinaria de Sevilla.</p>
            </div>
            <div>
                <h3>Dr. Carlos Martínez - Especialista en Cirugía</h3>
                <p>El Dr. Carlos Martínez es nuestro especialista en cirugía veterinaria. Su habilidad y precisión en el quirófano aseguran que cada procedimiento sea realizado con el mayor cuidado y profesionalismo.</p>
            </div>
            <div>
                <h3>Dra. Laura González - Especialista en Dermatología</h3>
                <p>La Dra. Laura González se especializa en el tratamiento de enfermedades de la piel en animales. Su enfoque integral y conocimientos avanzados en dermatología veterinaria garantizan el mejor tratamiento para las afecciones cutáneas de tus mascotas.</p>
            </div>
            <div>
                <h3>María Fernández - Técnico Veterinario</h3>
                <p>María Fernández es nuestra técnica veterinaria, responsable de asistir en procedimientos clínicos y proporcionar atención directa a nuestros pacientes. Su empatía y habilidades técnicas son fundamentales para el funcionamiento diario de nuestra clínica.</p>
            </div>

            <h2>Nuetros Servicios</h2>
            <p>En UPOVET Sevilla, ofrecemos una amplia gama de servicios para satisfacer todas las necesidades de tu mascota:</p>
            <ul>
                <li><strong>Consultas Generales y Preventivas:</strong> Evaluaciones de salud, vacunaciones, y chequeos regulares para prevenir enfermedades.</li>
                <li><strong>Cirugía:</strong> Procedimientos quirúrgicos avanzados con equipos de última generación.</li>
                <li><strong>Dermatología:</strong> Diagnóstico y tratamiento de problemas de la piel.</li>
                <li><strong>Odontología:</strong> Cuidados dentales completos para mantener la salud oral de tu mascota.</li>
                <li><strong>Emergencias:</strong> Atención de urgencias disponible las 24 horas del día, los 7 días de la semana.</li>
            </ul>

            <h2>Nuestras Instalaciones</h2>
            <p>Nuestras instalaciones están equipadas con tecnología de punta para asegurar diagnósticos precisos y tratamientos eficaces. Contamos con un área de hospitalización cómoda y segura para que las mascotas puedan recuperarse en un entorno tranquilo y supervisado.</p>

            <h2>Compromiso con la Comunidad</h2>
            <p>En UPOVET Sevilla, creemos en devolver a la comunidad. Colaboramos con refugios y organizaciones locales para promover la adopción de animales y proporcionar atención médica a aquellos que lo necesitan.</p>

            <h2>Contáctanos</h2>
            <p>¿Tienes alguna pregunta o deseas concertar una cita? No dudes en ponerte en contacto con nosotros:</p>
            <ul>
                <li><strong>Teléfono:</strong> +34 123 456 789</li>
                <li><strong>Correo Electrónico:</strong> clinicasupovet@gmail.com</li>
                <li><strong>Dirección:</strong> Calle de los Veterinarios, 123, 41001 Sevilla</li>
            </ul>

            <p>Estamos aquí para ayudarte y esperamos poder cuidar de tus queridos compañeros animales.</p>

            <p>Gracias por confiar en UPOVET Sevilla. Juntos, podemos asegurar una vida saludable y feliz para tus mascotas.</p>
        </div>
        <jsp:include page="FOOTER.jsp" />
    </body>
</html>

