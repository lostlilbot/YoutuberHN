package com.youtuberhn.data

import androidx.compose.ui.graphics.Color

data class Chapter(
    val id: String,
    val title: String,
    val content: String,
    val actionTitle: String,
    val actionDescription: String,
    val imageRes: Int? = null, // Resource ID for chapter image
    val gradientColors: List<Long> = listOf(0xFFFF0000, 0xFFFF6B6B) // Default YouTube red gradient
)

object BookContent {
    val chapters = listOf(
        Chapter(
            id = "prologo",
            title = "Prólogo: ¿Por qué este libro existe?",
            content = """
Si estás leyendo esto, probablemente tienes dos cosas: un celular con cámara y la duda de si en Honduras se puede vivir de YouTube. La respuesta corta es sí. La respuesta larga es el libro que tienes enfrente.

Honduras tiene desafíos únicos: internet inestable, falta de inversión local en creadores y un mercado publicitario pequeño. Pero también tiene una ventaja gigante: la autenticidad. El mundo está harto del contenido producido en estudios falsos de Estados Unidos o México. Quieren ver tu barrio, escuchar tu acento y conocer tu comida.

Este libro no es una traducción de un manual gringo. Es una ruta de batalla creada desde y para la realidad hondureña. Te enseñaré a grabar con 3,000 lempiras de equipo, a sortear los cortes de luz y a ganar tus primeros dólares aunque los bancos locales no entiendan de PayPal.
            """.trimIndent(),
            actionTitle = "Prepárate mentalmente",
            actionDescription = "Escribe 3 razones por las que querés ser YouTuber",
            gradientColors = listOf(0xFF6B4EFF.toLong(), 0xFF9B7DFF.toLong()) // Purple
        ),
        Chapter(
            id = "introduccion",
            title = "Introducción: El Mapa del Tesoro",
            content = """
Antes de empezar, necesitas saber cómo funciona esto.

No voy a endulzar la realidad: Fracasarás al principio. Tus primeros 10 videos serán malos. Pero si sigues este método, el video #50 será profesional.

El libro está dividido en 7 capítulos. Léelos en orden. No brinques del Capítulo 1 al 5 porque te emocionaste. Cada fase construye sobre la anterior. La promesa de este libro:

Al terminar los 7 capítulos, tendrás un canal estructurado, 10 ideas de video listas para grabar en Honduras, y sabrás exactamente cómo ganar tu primer Lempira o Dólar con tu contenido.

Ahora, prepárate. Deja las excusas. Vamos a empezar.
            """.trimIndent(),
            actionTitle = "Define tu nicho",
            actionDescription = "Escribe 5 temas que te apasionan y que podrías enseñar",
            gradientColors = listOf(0xFF2196F3.toLong(), 0xFF64B5F6.toLong()) // Blue
        ),
        Chapter(
            id = "capitulo1",
            title = "Capítulo 1: La Mentalidad Milionaria del Youtuber Hondureño",
            content = """
1.1 El Miedo al "Qué Dirán"

En Honduras, la cultura del "vos sabés quién es él?" es fuerte. Si empiezas un canal, habrá gente que se burle. Familiares que digan "dejá de perder el tiempo, buscá un trabajo de verdad".

La solución: Entiende que tu círculo social actual rara vez será tu audiencia. Tus primeros seguidores serán extraños en internet que sí valoran lo que haces. No le pidas permiso a tu tío para triunfar.

1.2 Gestionando la "Lógica del Hondureño" vs. La Lógica del Algoritmo

En Honduras, muchas veces pensamos en pequeño porque los recursos son escasos.

Error común: "Voy a grabar un video con mi celular chafa y ya, total, no tengo para una cámara cara".

La verdad: El algoritmo (YouTube) no sabe si tu cámara cuesta 5 mil o 50 mil lempiras. El algoritmo mide dos cosas: Retención (que vean el video completo) y Click (que entren al video). Una buena historia grabada con un celular viejo vence a una mala historia grabada con una Black Magic.

1.3 El "Internet Hundido" y cómo sobrevivir

Hablemos del elefante en la habitación: Tigo, Claro y los cortes de luz.

Realidad: No necesitas internet de fibra óptica de 100 megas para ser YouTuber. Lo necesitas para subir el video.

Estrategia del Campesino Digital:
1. Graba todo el contenido en una semana sin conexión.
2. Edita en tu casa (sin internet).
3. El fin de semana, busca el café, parque o casa de un familiar con el mejor internet. Subes todo y lo programas para que se publique durante la semana.

1.4 Define tu Nicho: ¿Qué carajos vas a grabar?

"Hacer YouTube" no es un nicho. Tienes que especializarte. En Honduras, los nichos con más futuro (y menos competencia estúpida) son:

• Comida Hondureña (Pero bien grabada): No basta con poner la cámara fija mientras hacés baleadas. Muéstralo como arte.
• Negocios y Emprendimiento Local: Cómo emprender en Honduras, casos de éxito de pequeños negocios.
• Turismo Extremo/Honduras Desconocida: Explora lugares que ni los hondureños conocen.
• Tutoriales Técnicos (Espanglish): Enseñar a usar software o tecnología, pero explicando términos en inglés que aquí usamos.
• Comedia de Observación (Slang Hondureño): Humor basado en las cosas que solo pasan aquí.

Acción del Día: Agarra tu cuaderno. Escribe 10 títulos de videos que te gustaría hacer basados en los nichos de arriba. Si no podés escribir 10, este capítulo no está completo. Volvé a leerlo.
            """.trimIndent(),
            actionTitle = "Escribe 10 títulos de video",
            actionDescription = "Crea 10 títulos poderosos para tu canal usando la fórmula: Cómo [beneficio] en [lugar/tiempo] sin [problema común]",
            gradientColors = listOf(0xFFFF0000.toLong(), 0xFFFF6B6B.toLong()) // YouTube Red
        ),
        Chapter(
            id = "capitulo2",
            title = "Capítulo 2: La Trincheras Digitales",
            content = """
Bienvenido al capítulo más práctico del libro. Aquí vamos a resolver el problema clásico del hondureño: "No tengo plata para equipo, ¿cómo le hago?"

Vamos a desglosar cómo armar un estudio funcional por menos de 3,000 Lempiras y cómo grabar aunque vivas en una zona donde la señal llega solo en un árbol específico del patio.

2.1 La Cámara: El Celular que ya tenés en la bolsa

Olvídate de comprar una Sony o una Canon ahora mismo. El 90% de los YouTubers exitosos empezado con su celular. En Honduras, los celulares de gama media (Xiaomi, Samsung A series, Motorola) ya graban en 1080p o 4K.

El Secreto está en la Estabilización: El peor enemigo de la imagen en celular es el movimiento. No necesitás un gimbal caro. Necesitás un trípode. Un trípode genérico de escritorio cuesta entre 300 y 500 lempiras en un negocio local o en un Mall.

Limpia el Lente: Suena tonto, pero el 50% de los videos malos en Honduras se deben a que el lente está lleno de grasa de baleada o polvo de la calle. Límpialo con una tela suave antes de cada grabación.

2.2 El Audio: El Factor Diferencial (y más importante que el video)

¿Has visto esos videos donde la imagen es regular, pero se escucha perfecto? Los ves hasta el final. ¿Has visto videos HD donde el sonido es de lata? Los cerrás a los 10 segundos.

Problema Hondureño: Vivimos en un país ruidoso. El carro de la pupusa, el vecino con música, el perro que no calla, el camión del gas tocando bocina.

La Solución Barata (Inversión Estrella): Comprá un micrófono de solapa (lavalier) genérico. En cualquier bazar tecnológico de Tegucigalpa o San Pedro Sula, o incluso en un "chino" del barrio, encontrás uno por 200 a 400 Lempiras. Se conecta directo al celular. Esto elimina el ruido de fondo y te pone al nivel de un podcast profesional.

El Truco del Hondureño Ahorrativo: Si no tenés esos 200 pesos, usá los audífonos que vienen con tu celular (los que tienen cable). Los audífonos con cable funcionan como micrófono de diadema. No es lo ideal, pero es mejor que el micrófono interno del celular.

2.3 La Luz: El Sol, tu Mejor Aliado Gratuito

En Honduras tenemos un recurso gratuito que en Europa pagan por imitar: Luz Solar de 7 a 10 de la mañana.

La Hora Dorada Hondureña: No grabes al medio día, cuando el sol da directo y te hace sombras de mapache en los ojos. Grabá en la mañana (de 7 a 9 AM) o en la tarde (de 3 a 5 PM). Buscá una ventana. Colocate de frente a la luz que entra.

Difumina la Luz: Si el sol te da muy fuerte, poné una cortina blanca (una sábana vieja sirve) para que la luz se suavice. Así te ves con piel de estrella de cine, no con cara de quemado por el sol catracho.

2.4 El Sonido Ambiente: Cómo tapar el "Ruido de Fondo" de Honduras

Ya hablamos del micrófono, pero hablemos de la escenografía.

La Grabadora vs. El Talento: Si vivís en una avenue principal, no grabes con la ventana abierta. Parecerá que estás dentro de una manifestación.

El Cuarto Alfombrado: El sonido rebota en paredes lisas. Si tu cuarto tiene eco (reverberación), métete al closet y grabá entre la ropa. O poné colchas en las paredes mientras grabás. Se ve feo, pero el audio sale perfecto, y en YouTube, el audio manda.

2.5 El Vestuario: La Maldición de las Rayas

Ley 1: No uses camisas con rayas muy finas o cuadros muy pequeños. En cámara, eso crea un efecto de "moiré" que vibra y distrae.

Ley 2: No uses ropa con letras muy pequeñas. La gente no las va a leer y ensucia la imagen.

Ley 3: Usá colores sólidos. Una camisa de color sólido (azul, rojo, verde, negro) te hace ver más profesional que una camisa de la selección (a menos que tu canal sea de fútbol).

2.6 El Espacio de Grabación: La "Cueva del Contenido"

No necesitás una oficina. Necesitás un rincón de tu casa al que puedas controlar.

El Fondo: Si grabás en tu cuarto, ordená la cama. Si grabás en la sala, poné una planta de fondo. El desorden visual mata el engagement. Si tu fondo es una pared blanca y fea, comprá una cortina barato y ponela de fondo.

La Privacidad: Dile a tu familia: "Voy a grabar por una hora, no entren, no hablen duro, no pongan música, no golpeen puertas". Si no lo hacés, en medio de tu mejor explicación, saldré tu abuela preguntando "¿querés café?".

Acción del Día:
Sin gastar dinero aún, recorré tu casa y encontrá tu "Rincón de Grabación". Identificá:
1. La ventana con mejor luz por la mañana.
2. Un fondo que no sea feo (o que puedas tapar con una sábana).
3. Un lugar silencioso (o el menos ruidoso).
Tomá una foto de ese lugar. Ese será tu primer estudio de grabación.
            """.trimIndent(),
            actionTitle = "Equipment Checklist",
            actionDescription = "Revisa qué equipo tenés y marca lo que ya tenés. Planifica qué comprar primero.",
            gradientColors = listOf(0xFF4CAF50.toLong(), 0xFF81C784.toLong()) // Green
        ),
        Chapter(
            id = "capitulo3",
            title = "Capítulo 3: La Estrategia de Contenido",
            content = """
Bienvenido al capítulo donde dejamos de lado la técnica y nos enfocamos en el combustible: las ideas. El 90% de los canales mueren porque el creador no sabe qué grabar después de la primera semana. Vamos a arreglar eso hoy.

3.1 El Error Fatal: El "Ya Grabo lo que me Salga"

Si te sentás frente a la cámara sin un guión, sin un esquema, sin un objetivo, tu video será una basura. Punto. En Honduras, donde el tiempo es oro y el internet es caro, no podés darte el lujo de subir basura.

La Solución: Tratá YouTube como un trabajo. Los canales profesionales tienen un banco de ideas. Tú vas a crear el tuyo hoy.

3.2 El Modelo de Parrilla de Contenido 3x3 (Hecho en Honduras)

Este es un método basado en la realidad del creador hondureño: a veces tenés tiempo, a veces no, a veces hay corte de luz, a veces hay "baleada timeout". Necesitás flexibilidad.

Vas a dividir tus videos en 3 categorías principales, con 3 tipos de esfuerzo cada una:

Categoría A: Los Tanates (Videos Grandes)
• Esfuerzo: Alto (Grabación de 3-4 horas, edición de 2 días).
• Objetivo: Crecer. Atraer gente nueva.
• Ejemplo Hondureño: Un documental corto sobre "Cómo hacen las pupusas en el mercado", o una aventura de 2 días en "La Tigra" contando tu experiencia.
• Frecuencia: 1 vez al mes.

Categoría B: La Cacería Diaria (Videos de Valor)
• Esfuerzo: Medio (Grabación de 1 hora, edición de 1 día).
• Objetivo: Educar o entretener a tus seguidores. Mantener el canal vivo.
• Ejemplo Hondureño: "Cómo hacer baleadas rápidas", "Review de un celular barato en La Lima", "Cómo evitar que te roben datos en el ciber".
• Frecuencia: 2 veces por semana.

Categoría C: Los Chanchuyos (Videos Rápidos)
• Esfuerzo: Bajo (Grabación en el celular, edición mínima en apps como CapCut).
• Objetivo: Aparecer en el feed, mantener presencia, engagement.
• Ejemplo Hondureño: Un Short (YouTube Shorts) de 30 segundos sobre "El chisme de la semana", "Un dato curioso de Honduras", o "Cómo se dice X palabra en catracho".
• Frecuencia: A diario (si podés).

3.3 El Banco de Ideas: 50 Temas en una Tarde

Si esperás a tener "inspiración", morirás de hambre. Necesitás un banco de ideas.

• La Fuente #1: El Chisme Local: ¿De qué está hablando la gente en tu colonia, en el bus o en el trabajo? Eso es tendencia. Si todos hablan del apagón, hacé un video sobre "Cómo sobrevivir al apagón en Honduras".
• La Fuente #2: Preguntas de tu Mamá/Tía: Lo que tu familia no entiende, el resto de Honduras tampoco. ¿Tu mamá no sabe usar WhatsApp Web? Hacé un tutorial.
• La Fuente #3: Google y YouTube Trends: Buscá "Cosas típicas de Honduras", "Comida hondureña", "Problemas de Honduras". Ve los videos que ya son populares y dales tu propio giro.

3.5 Los 4 Tipos de Video que Siempre Funcionan en el Mercado Hondureño

1. El Tutorial Práctico: "Cómoarle saldo a Tigo desde Estados Unidos", "Cómo comprar en Shein y que te llegue a Honduras sin que te roben".
2. La Historia Personal (Storytelling): "El día que me asaltaron en el rapidito y cómo reaccioné", "Mi primer viaje a La Ceiba solo". La gente conecta con historias, no con datos.
3. El Review de Producto Local: "Probé la nueva salsa de la baleada de la esquina, mire lo que pasó", "Review de los tenis baratos del mercado".
4. El Reto (Challenge): "Comí solo comida de pulpería por 24 horas", "Sobreviví un día en Tegucigalpa sin 5G".

3.6 El Guión Mínimo Viable

• La Estructura del Éxito:
1. La Promesa (Primeros 15 segundos): Di exactamente de qué vas a hablar y por qué la gente debe quedarse.
2. El Desarrollo (El chivo): Aquí cumplís la promesa. Das la información, mostrás el proceso, contás la historia.
3. El Cierre (Call to Action): Pediles que se suscriban, que comenten, que compartan. En Honduras, si no lo pedís, no lo hacen por pena.

Acción del Día:
Agarra tu cuaderno y creá tu primer "Banco de Ideas".
1. Escribí 5 ideas para la Categoría A (Tanates).
2. Escribí 5 ideas para la Categoría B (Cacería Diaria).
3. Escribí 5 ideas para la Categoría C (Chanchuyos/Shorts).
Si no tenés 15 ideas ahora mismo, volvé a leer la sección 3.3 y 3.5.
            """.trimIndent(),
            actionTitle = "3x3 Content Planner",
            actionDescription = "Planifica tu mes con la fórmula 3x3: 3 Tanates, 3 Cacerías Diarias, y los Chanchuyos que aparezcan",
            gradientColors = listOf(0xFFFF9800.toLong(), 0xFFFFB74D.toLong()) // Orange
        ),
        Chapter(
            id = "capitulo4",
            title = "Capítulo 4: La Grabación y el Arte de No Morir en el Intento",
            content = """
Bienvenido al capítulo más divertido y frustrante del libro. Aquí es donde la teoría se encuentra con la realidad: el perro que ladra, el vecino que empieza a taladrar justo cuando decís "hola, qué tal", y la bendita mototaxi que pasa con música de trápero a todo volumen.

Vamos a aprender a grabar en medio del caos.

4.1 La Preparación: El Ritual Pre-Grabación

Antes de presionar el botón rojo, hacé esto religiosamente:

• El Aviso de Zona de Guerra: Avisa a toda tu casa: "Voy a grabar durante 30 minutos. No entren, no hablen, no toquen la puerta, no pongan música, no golpeen nada. Si la casa se está incendiando, esperen 30 minutos." Sé drástico. La familia hondureña no respeta el "silencio" a menos que haya amenaza de muerte (o de castigo).

• El Checklist Técnico:
1. Memoria del celular: Borra basura. Nada peor que quedarte sin espacio en medio de la mejor toma.
2. Batería: Conectalo a la corriente o al power bank. Los cortes de luz no avisan.
3. Modo Avión: Activálo. Nada arruina más una toma que una llamada de Claro preguntándote si ya pagaste el plan.
4. Limpieza del lente: Repito, límpialo. El lente sucio es el sello del amateur.

4.2 El Ángulo de la Cámara: La Regla del Horizonte

En Honduras tenemos la costumbre de grabar mirando hacia arriba (como si la cámara estuviera en el suelo) o hacia abajo (enseñando el techo y el ventilador). Eso se ve feo.

La Regla de Oro: La cámara debe estar a la altura de tus ojos, o ligeramente por encima.

El Truco del Trípode Casero: Si no tenés trípode, apilá libros, cajas de zapatos o una silla. Poné el celular ahí. Que no tiemble. El movimiento excesivo es de video casero de cumpleaños, no de YouTuber profesional.

4.3 La Mirada: ¿Al Lente o a la Pantalla?

Cuando grabás con el celular, es fácil distraerte mirándote a vos mismo en la pantalla mientras hablás.

El Error: Si mirás la pantalla, en el video parecerá que estás viendo a un lado, no al público.

La Solución: Pegá un pedazo de cinta adhesiva o un post-it justo al lado de la cámara delante. Mirá fijamente a ese punto. Así, en el video, parecerá que estás mirando directamente a los ojos de tus espectadores. Eso crea conexión.

4.4 El Talento: Cómo Hablar Sin Morir de Pánico

Hablar solo frente a una cámara es antinatural. Al principio te dará vergüenza. Tu voz suena diferente. Te vas a trancar.

El Método del Chicle: No intentés ser perfecto. Los YouTubers exitosos no son perfectos, son auténticos. Si te trabás, reíte, corregí y seguí. Eso se puede editar.

Hablá como hablás: No intentés imitar un acento español o mexicano. Hablá en catracho. Usá tus modismos. "Vea", "mire", "qué onda", "púchica". Tu autenticidad es tu superpoder.

4.5 El Enemigo Público #1: El Ruido Externo

Vivimos en el país del ruido. Aquí está tu estrategia de combate:

• El Claxon y la Música de Bus: Si vivís cerca de una calle principal, identificá los horarios de menor tráfico. En Honduras, los horarios más silenciosos son:
- Domingo muy temprano (6-8 AM), mientras todo el mundo está crudo o durmiendo.
- Hora de la siesta (12-2 PM), cuando el sol aprieta y nadie sale.
- Después de las 9 PM (si no hay bolo cerca).

• El Perro que no Calla: Es el clásico. Cuando empezás a grabar, el perro del vecino ladra como si lo estuvieran matando. No te detengas. Hablá más fuerte (sin gritar) y editá el audio después. O poné música de fondo en el video para tapar los ladridos.

• El Vendedor Ambulante: "¡El queque, el queque, el pan de coco, el rosquete!" Si pasa justo cuando grabás, esperá. Esa grabación te quedó con sabor a pan. Pausá, respirá, y cuando se aleje, volvé a empezar la frase.

4.6 La Edición: La Magia del CapCut

No necesitás Adobe Premiere. Necesitás una app en tu celular llamada CapCut (es gratis).

Aprendé lo básico:
1. Cortar los silencios y los tropiezos.
2. Subir el volumen del audio.
3. Poner música de fondo (YouTube tiene librería gratis de música, buscála).
4. Poner texto (títulos, subtítulos).

El Estilo Hondureño: En Honduras, los videos muy producidos (con muchas transiciones raras) a veces se ven falsos. Ve al grano. Un video limpio, con buena información y sin tantas pendejadas visuales, retiene más gente.

4.7 El Bloqueo Creativo durante la Grabación

Estás grabando y de repente olvidás lo que ibas a decir. Pasa.

Solución: Tené tu guión o tus notas escritas en un papel justo al lado de la cámara (detrás del lente). Podés leer de vez en cuando. Nadie se va a dar cuenta si lo hacés natural.

4.8 La Toma Final: El Cierre

Nunca terminés un video con un "bueno, eso es todo, chao". Eso es aburrido.

El Cierre Catracho: Terminá con un resumen de lo que aprendieron, agradéceles por ver el video y hacé una pregunta: "¿Y vos, cómo hacés para que no te roben el internet? Dejámelo en los comentarios." Eso genera interacción, y la interacción hace que YouTube le muestre tu video a más gente.

Acción del Día:
Hoy no vas a publicar nada. Hoy vas a practicar.
1. Agarra tu celular.
2. Buscá tu rincón de grabación (el que identificaste en el Capítulo 2).
3. Presioná grabar y hablá durante 3 minutos sobre cualquier tema (tu comida favorita, por qué te gusta Honduras, lo que sea).
4. No lo edités. Solo míralo. Escuchá tu voz. Mira cómo te ves.
5. Borralo si querés. El objetivo no era el video, era perderle el miedo a la cámara.
            """.trimIndent(),
            actionTitle = "Graba 3 minutos ahora",
            actionDescription = "Abre la cámara y graba 3 minutos de práctica. Puede ser una intro, un mensaje, o lo que quieras practicar.",
            gradientColors = listOf(0xFFE91E63.toLong(), 0xFFF06292.toLong()) // Pink
        ),
        Chapter(
            id = "capitulo5",
            title = "Capítulo 5: Edición y Producción",
            content = """
Bienvenido al cuarto de guerra digital. La edición es donde los videos malos se vuelven buenos, y los videos buenos se vuelven virales. En Honduras, donde el tiempo es limitado y las computadoras a veces son lentas, necesitás un método eficiente.

5.1 El Software: Qué Usar Según tu Equipo

No todos tenemos una PC gamer con 16 GB de RAM. Aquí está tu guía de supervivencia:

• Si solo tenés celular (y es tu caso, sé honesto):
- CapCut: Es el estándar de oro. Es gratis, tiene música sin copyright, efectos, textos y es intuitivo. El 80% de los YouTubers hondureños exitosos editan aquí.
- InShot: Bueno para principiantes, especialmente para fotos y videos cortos.
- VN Editor: Similar a CapCut, pesa menos en el celular.

• Si tenés una computadora de escritorio o laptop (aunque sea regular):
- DaVinci Resolve: Es MÁS QUE ¡GRATIS! y profesional. Lo usa Hollywood. El problema: Requiere una computadora decente (mínimo 8 GB de RAM y gráficos dedicados si podés). Si tu PC es del gobierno o de las que regalan en la escuela, mejor quédate con CapCut.
- Filmora: Es de pago, pero más liviano que DaVinci. Buen punto medio.

• Si tenés una PC de la era de los 90s:
- Shotcut: Es gratis, open source, y corre hasta en una calculadora. La interfaz es fea, pero hace el trabajo.

5.2 El Flujo de Trabajo Eficiente (El Método de la Pulpería)

En una pulpería, todo tiene su lugar: la sal en un lado, los frijoles en otro. Tu edición debe ser igual de organizada. Si no, perdés horas buscando archivos.

1. Día de Grabación (El Saque): Grabás todo. Cuando terminás, pasás los videos a tu compu o a una carpeta en tu celular llamada "RAW" (crudos).
2. La Selección (El Corte Fino): Ves todo el material. Marcá las tomas buenas. Borrá las tomas donde te quedaste viendo feo, donde pasó un perro, o donde dijiste "este..." 50 veces.
3. La Edición (El Guiso): Arrastrá las tomas buenas a la línea de tiempo. Ordenalas como en tu guión.
4. El Sazón (Efectos y Música): Le ponés música de fondo, textos y transiciones (pero sin exagerar, no es una novela de Televisa).
5. La Cocción (Exportar): Lo guardás en formato de video.

5.3 El Ritmo: La Clave del Éxito en la Edición

El espectador hondureño (y el de cualquier lado) tiene la paciencia de un niño con hambre. Si te quedás callado 3 segundos, ya se fueron.

Cortá los Silencios: En la edición, eliminá todos los "ehhh", "mmm", "este...", y los silencios incómodos. El video debe fluir como agua de río.

El Ritmo Visual: Si es un tutorial, no dejés la misma toma por 5 minutos. Cada 15-20 segundos, cambiá el ángulo (si tenés otra cámara) o mostrá un acercamiento de lo que estás haciendo. Mantené el ojo del espectador entretenido.

5.4 El Audio en Edición: El Volumen y la Música

Normalizá el Volumen: En CapCut o DaVinci, hay una herramienta que se llama "Normalizar volumen" o "Aumentar audio". Usála. Nada peor que un video donde hay que subir el celular al máximo para oírte, y luego viene un golpe y ensordece a la gente.

La Música de Fondo:
- El Volumen de la Música: La música debe ser ambiente. Debe estar bajita, para que se escuche tu voz por encima. En CapCut, bajá el volumen de la música a 10-15% si estás hablando.
- Dónde conseguir música gratis: YouTube tiene su "Biblioteca de Audio" con música libre de derechos. También podés buscar "Música sin copyright" en YouTube y descargarla.

5.5 Las Transiciones: Menos es Más

En Honduras, nos gusta lo llamativo. Pero en edición, las transiciones de "estrella fugaz" o "remolino" se ven de tarea de escuela.

La Regla: Usá transiciones simples: cortes directos, o "fundido a negro" al principio y al final. Si querés ser más pro, usá el "fundido cruzado" (cross dissolve) de vez en cuando. Pero el 90% de tu video deben ser cortes directos.

5.6 Los Textos y Miniaturas (El Clickbait Honesto)

Subtítulos: Si podés, poné subtítulos automáticos. En YouTube se pueden generar, pero en CapCut también. Esto ayuda a la gente que ve sin sonido (en el bus, en el trabajo) y a los que tienen problemas de audición.

La Miniatura (El Thumbnail): Es lo más importante del video. Es el anuncio de tu video.

Cómo hacerla: Usá Canva (app gratis) o Photoshop si sabés.
Elementos: Una foto tuya con cara de sorpresa (o emoción), un fondo llamativo, y texto muy grande (máximo 4 palabras). Ejemplo: "¡NO COMAS ESTO!" o "COMO HACER BALEADAS".

El Error Hondureño: Poner letras pequeñas y muchos colores. La miniatura se ve chiquita en el celular. Hacéla simple y gritona.

5.7 Exportar: El Momento de la Verdad

Cuando terminés tu obra maestra, hay que sacarla del programa.

Configuración Mínima:
- Resolución: 1080p (Full HD). Si tu celular graba en 4K, exportá en 1080p para que pese menos.
- Formato: MP4.
- Framerate (FPS): 30 (es el estándar de YouTube).

El Ensayo General: Antes de subirlo, mirá el video completo de principio a fin en tu celular. ¿Se escucha bien? ¿La música no tapa tu voz? ¿Los textos se entienden? Si algo falla, corregí antes de subir. En Honduras, el internet cuesta, así que no podés darte el lujo de subir el video dos veces.

Acción del Día:
Abrí CapCut (o el programa que hayas elegido).
1. Importá el video de práctica que grabaste en el Capítulo 4.
2. Cortá los silencios y los tropiezos.
3. Ponéle música de fondo (bajita).
4. Ponéle un título al principio y tu nombre al final.
5. Exportá el video y míralo. Acabás de hacer tu primer video editado. Aunque sea malo, lo hiciste. Eso es un avance.
            """.trimIndent(),
            actionTitle = "Editor de video simple",
            actionDescription = "Edita tu video de práctica: importa el video, agrega texto introductorio y música de fondo",
            gradientColors = listOf(0xFF00BCD4.toLong(), 0xFF4DD0E1.toLong()) // Cyan
        ),
        Chapter(
            id = "capitulo6",
            title = "Capítulo 6: Publicación y el Algoritmo",
            content = """
Has grabado, has editado, has sufrido. Ahora viene lo que separa a los soñadores de los verdaderos YouTubers: publicar estratégicamente. No se trata solo de subir el video y esperar. Se trata de engañar al algoritmo para que le muestre tu contenido a quien realmente le interesa.

6.1 La Preparación: Antes de Hacer Click en "Publicar"

Antes de subir el archivo, asegurate de tener todo esto listo. Si no, el algoritmo te ignorará:

El Título (La Trampa): Debe tener gancho. Debe incluir la palabra clave principal.
- Malo: "Video de baleadas"
- Bueno: "Cómo hacer baleadas hondureñas en 5 minutos | Receta fácil y barata"
- Regla: Máximo 60 caracteres para que se vea completo en el celular. Usá palabras que un hondureño buscaría: "receta", "hondureño", "fácil", "barato", "tips", "tutorial".

La Descripción (El Mapa):
- En los primeros 150 caracteres poné un resumen con tu palabra clave.
- Ejemplo: "En este video te enseño a hacer baleadas hondureñas con una receta fácil y económica. Ideal para desayunos en Honduras."
- Luego, poné links a tus redes, a tus videos relacionados y agradecé.

Las Etiquetas (Tags):
- En YouTube Studio, poné entre 5 y 10 etiquetas. Ejemplo: baleadas, comida hondureña, receta hondureña, cocinar en Honduras, desayuno catracho.
- No pongas 30 etiquetas irrelevantes como "comidamexicana". Eso confunde al algoritmo.

La Miniatura (El Vestido de Novia):
- Ya hablamos de hacerla llamativa. Asegurate de subirla manualmente. No dejes que YouTube escoja un frame al azar. Si lo hacés, tu video morirá.

6.2 El Mejor Horario para Publicar en Honduras

Esto es crucial. No es lo mismo publicar a las 2 AM que a las 6 PM. La audiencia hondureña tiene horarios específicos:

Entre Semana (Lunes a Viernes):
- 6:00 PM - 8:00 PM: La gente ya salió del trabajo o la universidad, llegó a casa, está comiendo o descansando. Es el horario prime.
- 12:00 PM - 1:00 PM: La hora del almuerzo. La gente ve videos mientras come.

Fines de Semana:
- Sábado 9:00 AM - 11:00 AM: La gente amanece, desayuna, y ve contenido.
- Domingo 7:00 PM - 9:00 PM: Después de la novela o el partido, antes de dormir para empezar la semana.

El Truco del Zona Horaria: Recordá que los hondureños en Estados Unidos ven tu contenido. Publicar entre 6-8 PM hora de Honduras equivale a 7-9 PM hora del Este de USA (Nueva York, Miami), donde hay muchos catrachos.

6.3 El Internet Hondureño: Cómo Subir Videos Gigantes sin Llorar

Subir un video de 10 minutos en 1080p puede ser una pesadilla con nuestro internet.

El Método del Madrugador: Levantate a las 4 o 5 de la mañana a subir el video. A esa hora, el ancho de banda está menos saturado en Honduras. La mayoría de la gente duerme y el internet vuela.

El Café con WiFi: Ve a un lugar con WiFi público (un café, un parque, la casa de un familiar con fibra óptica). Llevá tu laptop o tu celular con el video ya exportado en un USB OTG (adaptador). Pedí un café, conectate y subilo.

6.4 Después de Publicar: Los Primeros 60 Minutos (La Hora Santa)

Las primeras 2 horas después de publicar son sagradas. YouTube mira si tu video está generando tracción.

El Golpe Inicial: Compartí el video inmediatamente en:
- Tus estados de WhatsApp (los hondureños vivimos en WhatsApp).
- Tus grupos de familia y amigos (pediles que lo vean y comenten, aunque sea con un emoji).
- Tus historias de Instagram y Facebook.

Respondé Comentarios: Si alguien comenta en la primera hora, respondé. Eso le dice a YouTube que hay actividad y te empuja en el algoritmo.

No lo Compartas en Grupos de Spam: Evitá esos grupos de "intercambio de vistas" donde nadie ve el video realmente. YouTube detecta tráfico falso y te penaliza. Mejor compartilo en grupos donde la gente realmente esté interesada en tu tema.

6.5 El Algoritmo Explicado en Hondureño

El algoritmo no es tu enemigo, es tu jefe. Quiere una sola cosa: que la gente pase tiempo en YouTube.

Las 3 métricas que importan:
1. CTR (Click Through Rate): ¿La gente hace click en tu video cuando ve la miniatura? Si es bajo, cambiá la miniatura y el título.
2. Retención (Average View Duration): ¿La gente ve el video completo o lo cierra a los 30 segundos? Si lo cierran, es porque tu introducción es aburrida o tu título era mentira.
3. Interacción: ¿Commentan? ¿Dan like? ¿Comparten? Pedí esto explícitamente: "Regalame un like si te gustó", "Compartí este video con tu mamá".

6.6 El Día Después: Analizá tus Estadísticas

No publiques y te olvides. Al día siguiente, entrá a YouTube Studio (app o web) y mirá:
- Alcance: ¿Cuántas vistas tuviste?
- Fuente de tráfico: ¿La gente llegó desde la búsqueda de Google? ¿Desde videos sugeridos? ¿Desde tus redes? Si llegaron desde búsqueda, significa que tu título y etiquetas funcionaron.
- Retención: Mirá el gráfico. ¿En qué segundo la gente dejó de ver? Ahí tenés tu error. Si la gente se va al principio, tu introducción es mala. Si se va a la mitad, el contenido se puso aburrido.

6.8 La Consistencia: El Verdadero Secreto del Éxito

El mayor error del hondureño promedio es subir un video, espera hacerse millonario en una semana, y al no ver resultados, abandonar el canal.

El Plan Realista:
- Subí 1 video de calidad a la semana (Categoría A o B).
- Subí 2-3 Shorts diarios (Categoría C) para mantener presencia.
- La Promesa: Si mantenés esta frecuencia durante 6 meses, tendrás más de 1000 suscriptores (casi seguro). Si abandonás a los 2 meses, tendrás 30 suscriptores y amargura.

Acción del Día:
Agenda tu primer video. Definí:
1. El día y hora exacta de publicación (basado en el punto 6.2).
2. Escribí 3 posibles títulos para ese video (el mejor, el segundo mejor, el clickbait).
3. Diseñá la miniatura en Canva.
No subas nada hasta que esto esté listo.
            """.trimIndent(),
            actionTitle = "Planifica tu publicación",
            actionDescription = "Crea un calendario de publicación para los próximos 7 días",
            gradientColors = listOf(0xFF9C27B0.toLong(), 0xFFBA68C8.toLong()) // Purple
        ),
        Chapter(
            id = "capitulo7",
            title = "Capítulo 7: La Monetización",
            content = """
Llegamos al capítulo que todos esperan: la plata. Porque está bien tener sueños, pero los sueños pagan la baleada y el internet. Aquí te explico cómo funciona el dinero en YouTube desde la trinchera catracha.

7.1 Los Requisitos para Monetizar en 2026 (El Pacto con el Diablo)

Para que YouTube te paga, necesitás cumplir estos requisitos (y no, no hay atajos):

1. 1000 suscriptores: La comunidad. Gente que voluntariamente dijo "quiero ver más de este catracho".
2. 4000 horas de visualización en el último año: Esto equivale a que la gente vea tus videos, no solo que haga click. Esto es más difícil que los suscriptores.
3. Vivir en un país admitido: ¡Buenas noticias! Honduras sí está en la lista de países de AdSense para Adsense (publicidad). Pero hay un problema con las formas de pago, que veremos después.
4. No tener strikes de derechos de autor: Si usaste música de tu artista favorito sin permiso, no te aceptan.

7.2 El Proceso: Cómo Aplicar

Cuando cumplas los requisitos, YouTube te notificará automáticamente. Irás a YouTube Studio -> Monetización -> Unirte al Programa de Socios de YouTube.

Te pedirán crear una cuenta de AdSense (la empresa de Google que paga). Esto puede ser tedioso. Necesitás:
- Una dirección física en Honduras (tu casa).
- Un número de teléfono hondureño (que funcione).
- Identidad (DNI o pasaporte).

Google te enviará un código de verificación por correo postal a tu casa en Honduras. Esto puede tardar de 2 semanas a 2 meses. Tené paciencia. Si no recibís nada, revisá en la oficina de correos de tu ciudad o pedí una nueva verificación.

7.3 El Gran Problema Hondureño: ¿Cómo me pagan y cómo saco la plata?

Aquí está el verdadero dolor de cabeza. Google paga por cheque, transferencia bancaria internacional (wire transfer) o Western Union Quick Cash. Pero en Honduras, los bancos ponen peros.

Opción 1: El Cheque (La más riesgosa)
- Google te envía un cheque en dólares a tu casa.
- Lo llevás a tu banco (BAC, Ficohsa, Atlántida, etc.).
- El banco lo recibe, lo procesa y te lo cambia a lempiras.
- Problema: El cheque puede perderse en el correo (no es raro). El banco te cobra una comisión por cobrar cheques del extranjero (entre $15 y $30). Tarda hasta 30 días en hacerse efectivo. Y si el cheque es por $100, te quedan $70 después de comisiones y conversión. Duele.

Opción 2: Transferencia Bancaria (Wire Transfer) (La más rápida pero compleja)
- AdSense te deposita directamente a tu cuenta bancaria en Honduras.
- Requisito: Tu banco debe aceptar transferencias SWIFT internacionales. La mayoría (BAC, Ficohsa, Promerica) lo hacen.
- Problema: El banco intermediario y el banco local te cobran comisiones. Pueden quitarte entre $20 y $40 por transferencia. Si te depositan $200, te llegan $160.
- Solución: Acumulá varios meses de pago para que la transferencia sea grande y la comisión duela menos.

Opción 3: Western Union Quick Cash (La favorita de muchos)
- AdSense te da un código y vas a una agencia de Western Union en Honduras a cobrar.
- Problema: Tenés que ir personalmente, hacer fila, y mostrar identidad. Solo disponible en ciertos montos.
- Ventaja: Llega rápido (días) y a veces las comisiones son más claras.

Opción 4: Payoneer (La solución moderna)
- Mi recomendación personal. Crea una cuenta en Payoneer (es gratis). Payoneer te da una cuenta bancaria en Estados Unidos (virtual).
- Configurás AdSense para que te pague a esa cuenta de Payoneer (como si fuera una transferencia local en USA, sin comisiones internacionales).
- Payoneer recibe el dinero. Luego podés:
- Retirar a un banco hondureño (por una comisión fija, a veces más barata que la transferencia directa).
- Usar la tarjeta de Payoneer para comprar en línea o pagar servicios.
- Cambiar a lempiras cuando el tipo de cambio te convenga.

7.4 Más Allá de los Adsense: El Verdadero Negocio (El Patrocinio Local)

En Honduras, los anuncios de YouTube (Adsense) pagan muy bajo (CPM bajo). Un video con 10,000 vistas en Honduras te puede pagar $20-$30 dólares. En Estados Unidos, esas mismas vistas pagan $200. La solución es no depender solo de eso.

El Patrocinio Local (La Mina de Oro):
- Cuando tengas un canal con 2000-3000 vistas por video, negocios locales te pagarán por aparecer.
- Ejemplo: Si tenés un canal de comida, andá a una pupusería y deciles: "Les hago un video mostrando su negocio y cómo hacen las pupusas por $50 dólares (1200 lempiras)". Para ellos, es publicidad barato. Para ti, es más de lo que te pagaría YouTube.
- Negocios que pagan: Restaurantes, tiendas de ropa, talleres mecánicos, universidades, ventas de celulares, marcas de energía.

El Marketing de Afiliados:
- Unite a programas de afiliados como el de Mercado Libre o Amazon Associates.
- En tus videos de tecnología o productos, dejás un link: "Comprá este celular aquí". Si alguien compra, vos ganás comisión.

Vender tu Propio Producto (El Sueño):
- Una vez que tenés una audiencia que confiar en vos, podés vender:
- Cursos: "Aprende a hacer baleadas profesionales" (si tu nicho es cocina).
- Ebooks: "Guía para sobrevivir en Honduras" (si tu nicho es estilo de vida).
- Camisetas o tazas: Con frases hondureñas o de tu canal.

7.5 La Calculadora Real: ¿Cuánto se puede ganar en Honduras?

Seamos honestos. No te harás millonario en 3 meses. Pero con trabajo, sí podés reemplazar un salario promedio.

• Nivel 1 (Principiante): 1000-5000 suscriptores. Ganas entre $50 y $200 al mes (1200 a 4800 lempiras) combinando Adsense y algún patrocinio pequeño. Bueno para los gastos del internet.
• Nivel 2 (Intermedio): 5000-20,000 suscriptores. Ganas entre $300 y $800 al mes (7200 a 19,200 lempiras) con Adsense + patrocinios locales regulares. Ya compite con un trabajo formal.
• Nivel 3 (Avanzado): 20,000+ suscriptores. Ganas $1000+ al mes (24,000+ lempiras). Ya podés vivir de esto en Honduras cómodamente.

7.7 El Fondo de Emergencia del Youtuber Hondureño

El dinero de YouTube no es fijo. Un mes ganás $500, otro mes $150. Por eso:

• Ahorrá en dólares: Si podés, mantené tus ahorros en dólares (en una cuenta en dólares o en Payoneer) para protegerte de la devaluación del lempira.
• No te endeudes: No comprés equipo caro a crédito basado en lo que "esperás" ganar. Comprá cuando ya tengas el dinero en la mano.

7.8 El Plan de los 12 Meses

Aquí está tu ruta de acción para el primer año:

• Meses 1-3: Aprendé a grabar y editar. Publicá 1 video a la semana. No importan las vistas. Concéntrate en mejorar.
• Meses 4-6: Encontrá tu nicho y mejorá tu contenido. Empezá a ver crecimiento lento. Llegarás a 300-500 suscriptores.
• Meses 7-9: Sé consistente. Publicá 2 videos por semana. Llegarás a 800-1000 suscriptores y empezarás a aplicar a monetización.
• Meses 10-12: Ya monetizado. Empezá a buscar tu primer patrocinio local. Llegarás a 2000-3000 suscriptores si mantenés la calidad.
            """.trimIndent(),
            actionTitle = "Calculadora de monetización",
            actionDescription = "Ingresa tus vistas estimadas y ve cuánto podrías ganar en lempiras",
            gradientColors = listOf(0xFFFFEB3B.toLong(), 0xFFFFF176.toLong()) // Yellow/Gold
        ),
        Chapter(
            id = "conclusion",
            title = "Conclusión: El Último Consejo del Catracho Viejo",
            content = """
Hemos llegado al final de este libro. Pero tu viaje apenas empieza.

Honduras no es el país más fácil para ser YouTuber. Tendrás días donde el internet no sirva, donde la gente te critique, donde te preguntés si vale la pena. Pero déjame decirte algo:

Honduras necesita tus historias.

Necesita que alguien muestre la belleza de este país que los medios solo muestran como peligroso.
Necesita que alguien enseñe a cocinar como la abuela antes de que se pierdan las recetas.
Necesita que alguien haga reír con el humor único que tenemos los catrachos.

El algoritmo no premia al mejor equipo. Premia a la autenticidad.

Y vos, maje, sos auténtico aunque no lo creas. Agarrá tu celular. Limpiá el lente. Buscá la luz de la ventana.

Y grabá.

Nos vemos en YouTube.

---

¿Qué sigue?

Si has leído todo hasta aquí y has hecho las acciones de cada capítulo, ya tenés:
1. Un nicho definido.
2. Un rincón de grabación identificado.
3. Un banco de 15 ideas.
4. Un video de práctica editado.
5. Una estrategia de publicación.
6. Un plan para monetizar.

Ahora, la pelota está en tu cancha.

FIN DEL LIBRO
            """.trimIndent(),
            actionTitle = "¡Es tu momento!",
            actionDescription = "Escribe tu primer video hoy y comprométete a no parar",
            gradientColors = listOf(0xFF4CAF50.toLong(), 0xFFA5D6A7.toLong()) // Green
        )
    )
}
