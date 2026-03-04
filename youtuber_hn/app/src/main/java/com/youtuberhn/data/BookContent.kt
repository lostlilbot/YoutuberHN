package com.youtuberhn.data

data class Chapter(
    val id: String,
    val title: String,
    val content: String,
    val actionTitle: String,
    val actionDescription: String
)

object BookContent {
    val chapters = listOf(
        Chapter(
            id = "prologo",
            title = "Prólogo",
            content = """
¡Púchica, bienvenido a esta guía definitiva! Aquí vas a aprender cómo crear contenido en YouTube desde Honduras y vivir de internet, aunque tengas internet chafa y luz inestable.

Este libro está diseñado para vos, un catracho con sueños grandes que quiere salir adelante. No importa si no tenés equipo caro o experiencia previa. Lo que importa es la actitud y la constancia.

Vamos a paso a paso, sin tecnicismos complicados. Vas a ver que con un celular básico podés empezar a crear contenido genial. ¡Empecemos esta journey juntos!
            """.trimIndent(),
            actionTitle = "Prepárate mentalmente",
            actionDescription = "Escribe 3 razones por las que querés ser YouTuber"
        ),
        Chapter(
            id = "introduccion",
            title = "Introducción",
            content = """
En Honduras, tenemos algo especial: somos los más creativos de Centroamérica. Eso no es chauvinismo, es realidad. Nous vemos en cada baleada, en cada chiste, en cada forma de resolver problemas con lo que tenemos.

YouTube es la oportunidad perfecta para mostrar tu creatividad al mundo. Y lo mejor es que podés empezar hoy mismo, sin gastar mucha plata.

Esta guía te va a llevar desde cero hasta poder vivir de tu canal. Cada capítulo tiene una acción práctica que vas a hacer HOY. No es teoría vacía, es acción directa.

Vamos a covers desde qué equipo usar, cómo planificar tu contenido, cómo grabar, editar, publicar y monetizar. Todo adaptado a la realidad Hondureña.
            """.trimIndent(),
            actionTitle = "Define tu nicho",
            actionDescription = "Escribe 5 temas que te apasionan y que podrías enseñar"
        ),
        Chapter(
            id = "capitulo1",
            title = "Capítulo 1: Cómo Empezar",
            content = """
El primer paso es el más importante: definir qué vas a hacer. No podés ser un YouTuber de "todo" porque así no te conoce nadie.

Tenés que encontrar tu nicho. ¿Qué sabés hacer vos mejor que la mayoría? ¿Qué te gusta hablar horas sin aburrirte?

Puede ser:
- Recetas de comida Hondureña
- Gaming (videojuegos)
- Música y producción
- Comedia y sketches
- Tutoriales de tecnología
- Vida diaria en Honduras
- Fútbol y deportes

Una vez que tengas tu nicho, necesitás crear tu primera lista de títulos. Los títulos son lo más importante porque son lo primero que ve la gente.

En YouTube, el título es como la cara de tu video. Si no llama la atención, nadie le da click. Por eso vamos a practicar creando 10 títulos poderososHOY.

Recordá: no necesitás tener todo listo. El 80% del éxito es empezar. ¡Manos a la obra, mae!
            """.trimIndent(),
            actionTitle = "Escribe 10 títulos de video",
            actionDescription = "Crea 10 títulos poderosos para tu canal usando la fórmula: Cómo [beneficio] en [lugar/tiempo] sin [problema común]"
        ),
        Chapter(
            id = "capitulo2",
            title = "Capítulo 2: Equipo Básico",
            content = """
¡Ah, el equipo! La mayoría de la gente cree que necesita miles de lempiras para empezar. ¡Púchica, eso es mentira!

Con un celular moderno ya tenés el 90% de lo que necesitás. Los celulares de ahora graban en 4K, que es más que suficiente para YouTube.

Pero sí hay algunas cosas que van a mejorar tu calidad:

1. TRÍPODE: Básico para que no tiemble el video. Conseguilo en cualquier tienda por ahí.

2. ANILLO DE LUZ: Para que se vea bien tu cara. Cuestan como 300-500 lempiras.

3. MICRÓFONO EXTERNO: El del celular está bien para empezar, pero uno Lavalier es mejor. Cuestan como 400-800 lempiras.

4. ILUMINACIÓN NATURAL: Si tenés una ventana, usala. La luz del sol es la mejor.

No gastes en equipo caro hasta que tengas más experiencia. Con lo básico llegás lejos.

Ahora, vas a hacer el checklist de equipo para ver qué tenés y qué te falta.
            """.trimIndent(),
            actionTitle = "Equipment Checklist",
            actionDescription = "Revisa qué equipo tenés y marca lo que ya tienes. Planifica qué comprar primero."
        ),
        Chapter(
            id = "capitulo3",
            title = "Capítulo 3: Planificación de Contenido",
            content = """
El secreto del éxito en YouTube es la constancia. No podés subir un video y esperar que te vuelvas famoso. Tenés que publicar regularmente.

Por eso necesitás un plan de contenido. No es cosa de "cuando se me ocurra". Es cosa de tener un calendario y seguirlo.

Vamos a usar el sistema de los 3 pilares:

1. TANATES (Videos principales): Son tus videos de siempre, tu contenido base. Los que más te definen.

2. CACERÍA DIARIA: Videos cortos de lo que pasa en el día. Reacciones, comentarios, situaciones random.

3. CHANCHUYOS: Videos de oportunidad. Cosas que pasan y que podés aprovechar rápido.

La fórmula mágica: 3x3
- 3 videos principales al mes
- 3 cacerías diarias por semana
- Los chanchuyos cuando aparezcan

Esto te da 12+ videos al mes sin morir en el intento.

El banco de ideas es clave. Tenés que tener siempre una lista de temas pendientes. La regla de los 50: siempre tené 50 ideas de videos en tu lista.

¡Vamos a planificar tu mes!
            """.trimIndent(),
            actionTitle = "3x3 Content Planner",
            actionDescription = "Planifica tu mes con la fórmula 3x3: 3 Tanates, 3 Cacerías Diarias, y los Chanchuyos que aparezcan"
        ),
        Chapter(
            id = "capitulo4",
            title = "Capítulo 4: Grabación",
            content = """
¡Hora de grabar! Pero antes, algunos tips clave:

1. ESCRIBE UN SCRIPT (guión): No tiene que ser perfecto, pero tené claro qué vas a decir. Nobody wants to improvise for 10 minutes.

2. LOOK PROFESIONAL: Vestite bien, peinate, aunque sea para el celular. La primera impresión cuenta.

3. NO TE PREOCUPES POR ERRORES: Es normal equivocarse. En edición se corrige todo.

4. GRABA MÁS DE LO NECESARIO: Siempre grabá más de la cuenta. Después editás lo mejor.

5. PRACTICA FRENTE A LA CÁMARA: Al principio vas a sentir raro. Es normal. Practicando se mejora.

El primer video que grabes no va a ser perfecto. Y el segundo tampoco. Pero cada uno va a ser mejor que el anterior.

La práctica hace al maestro. Por eso hoy vas a grabar 3 minutos de práctica. No tiene que ser perfecto, solo tiene que ser. ¡Grabá y subilo! Even if it's just practice.
            """.trimIndent(),
            actionTitle = "Graba 3 minutos ahora",
            actionDescription = "Abre la cámara y graba 3 minutos de práctica. Puede ser una intro, un mensaje, o lo que quieras practicar."
        ),
        Chapter(
            id = "capitulo5",
            title = "Capítulo 5: Edición",
            content = """
La edición es donde la magia sucede. Un video malo puede convertirse en uno decente con buena edición. Y uno bueno puede ser épico.

Pero no te obsesiones con ser un editor profesional desde el inicio. YouTube premia el contenido, no la edición perfecta.

Software gratuito para empezar:
- CapCut (celular) - Muy fácil, buen resultado
- DaVinci Resolve (computadora) - Potente y gratis
- Windows Movie Maker - Básico pero funciona

Lo básico que tenés que saber:
1. CORTA los errores y silencios
2. AGREGA música de fondo (sin copyright)
3. PONE subtítulos (muchos ven sin sonido)
4. USA transiciones simples
5. MEJORA el audio

La regla de oro: menos es más. No exageres con efectos. El contenido es lo importante.

Hoy vas a editar un video simple. Importá tu práctica de ayer y agregale texto y música.
            """.trimIndent(),
            actionTitle = "Editor de video simple",
            actionDescription = "Edita tu video de práctica: importa el video, agrega texto introductorio y música de fondo"
        ),
        Chapter(
            id = "capitulo6",
            title = "Capítulo 6: Publicación",
            content = """
¡Tu video está listo! Ahora viene lo tricky: publicarlo bien.

El timing importa. No es lo mismo publicar a las 2am que a las 6pm. Depends on tu audiencia.

En Honduras, los mejores horarios son:
- Martes a jueves: 6pm - 9pm
- Sábados y domingos: 10am - 12pm

Pero también depende de tu nicho. Si es para niños, mañana es mejor. Si es para adultos, noche.

Además del horario, necesitás:
1. TÍTULO optimizeado (con palabras clave)
2. MINIATURA atractiva (lo más importante)
3. DESCRIPCIÓN con timestamps y links
4. TAGS relevantes

La miniatura es 90% del éxito del click. Tené colores brillantes, texto grande, y tu cara reacting.

El algoritmo de YouTube favorece a quienes publican consistentemente. No es tanto sobre un video viral, es sobre construir una audiencia leal.

¡Planificá tu publicación para la semana!
            """.trimIndent(),
            actionTitle = "Planifica tu publicación",
            actionDescription = "Crea un calendario de publicación para los próximos 7 días"
        ),
        Chapter(
            id = "capitulo7",
            title = "Capítulo 7: Monetización",
            content = """
¡Vamos a la plata! YouTube tiene varias formas de ganar dinero:

1. ADSENSE (el más común): Ganas por los anuncios que aparecen en tus videos. Necesitás 1000 suscriptores y 4000 horas de visualización.

2. SPONSORS: Marcas te pagan por mencionar sus productos. Esto es donde está la verdadera plata.

3. MEMBERSHIPS: Tus fans pagan mensual para tener beneficios exclusivos.

4. SUPER CHATS y STICKERS: Gente te paga para destacar en lives.

5. MERCHANDISE: Vender tu propia marca de playeras, taza, etc.

Para empezar con Adsense, la meta es clara: 1000 suscriptores + 4000 horas. Sounds like a lot, pero con contenido consistente lo lográs.

Una vez que tengas monetization activada, YouTube te paga en dólares convertidos a lempiras. ¡Imaginate recibir $500 al mes trabajando desde tu cuarto!

La calculadora de monetización te va a ayudar a ver cuánto podrías ganar según tus vistas.

Pero recordá: la monetization es consecuencia, no el objetivo. El objetivo es crear contenido que la gente quiera ver. ¡Seguí creando y la plata llega!
            """.trimIndent(),
            actionTitle = "Calculadora de monetización",
            actionDescription = "Ingresa tus vistas estimadas y ve cuánto podrías ganar en lempiras"
        ),
        Chapter(
            id = "conclusion",
            title = "Conclusión",
            content = """
¡Lo lograste! Has llegado al final de esta guía. Pero esto es solo el comienzo de tu journey como YouTuber Hondureño.

Recordá las claves del éxito:
1. CONSTANCIA - Publicá regularmente
2. AUTENTICIDAD - Se vos mismo, no copies a nadie
3. PERSEVERANCIA - No te rindas cuando las cosas estén difíciles
4. MEJORA CONSTANTE - Siempre aprendé y evolucioná

Honduras necesita más creadores de contenido. Necesitamos mostrarle al mundo lo creativos que somos los catrachos. Tu voz importa. Tu historia importa.

El internet niveló el campo de juego. Ya no necesitás estar en Tegucigalpa o San Pedro Sula para tener éxito. Podés estar en La Ceiba, Choluteca, o donde sea.

Esta guía te dio las herramientas. Ahora depende de vos ponerlas en acción. No esperes al "momento perfecto". El momento perfecto es HOY.

¡Empezá ahora mismo! Subí tu primer video esta semana. No esperes más.

Y cuando te vuelvas famoso, recordá que empezaste con esta guía. ¡Éxito, mae! 🔥

¡A crear, catracho! 💪
            """.trimIndent(),
            actionTitle = "¡Es tu momento!",
            actionDescription = "Escribe tu primer video hoy y comprométete a no parar"
        )
    )
}
