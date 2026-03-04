# 🎬 De Cero a Youtuber en Honduras 🇭🇳

Una aplicación Android completa para aprender a crear contenido en YouTube desde Honduras. Aprende a grabar, editar y monetizar tu canal con consejos adaptados a la realidad hondureña.

## 📱 Características

### Libro Interactivo
- **10 capítulos completos** con contenido sobre YouTube en Honduras
- **Gradientes personalizados** para cada capítulo según su tema
- **Navegación fácil** con menú lateral (hamburger menu)
- **Búsqueda integrada** para encontrar contenido rápidamente

### Funcionalidades Principales
- 📖 **Capítulos**: Lee el libro completo sobre cómo ser YouTuber
- 🎯 **Acciones del Día**: Ejercicios prácticos para cada capítulo
- 🔧 **Herramientas**: Banco de ideas, recordatorios y horarios
- ✨ **Extras**: Búsqueda, modo oscuro, exportar notas
- 🎬 **Grabar Video**: Cámara integrada para practicar

### Diseño
- 🎨 **Tema de YouTube** (Rojo #FF0000)
- 🌙 **Soporte para modo oscuro**
- 📱 **Diseño Material Design 3**
- 🎯 **Navegación lateral con menú hamburguesa**

## 📚 Contenido del Libro

1. **Prólogo**: ¿Por qué este libro existe?
2. **Introducción**: El Mapa del Tesoro
3. **Capítulo 1**: La Mentalidad Milionaria del Youtuber Hondureño
4. **Capítulo 2**: La Trincheras Digitales (Equipo)
5. **Capítulo 3**: La Estrategia de Contenido
6. **Capítulo 4**: La Grabación y el Arte de No Morir en el Intento
7. **Capítulo 5**: Edición y Producción
8. **Capítulo 6**: Publicación y el Algoritmo
9. **Capítulo 7**: La Monetización
10. **Conclusión**: El Último Consejo del Catracho Viejo

## 🛠️ Tecnología

- **Kotlin** - Lenguaje de programación
- **Jetpack Compose** - UI moderna para Android
- **Material Design 3** - Sistema de diseño
- **Navigation Compose** - Navegación en la app
- **CameraX** - Cámara para grabar videos
- **Gradle** - Sistema de build

## 📦 Descargar APK

**[Descargar YoutuberHN.apk](https://github.com/lostlilbot/YoutuberHN/releases/latest)**

## 🚀 Cómo Instalar

1. Descarga el archivo APK del [release más reciente](https://github.com/lostlilbot/YoutuberHN/releases/latest)
2. En tu teléfono Android, permite instalación de apps de fuentes desconocidas
3. Abre el archivo APK y selecciona "Instalar"
4. ¡Listo! Ya puedes aprender a ser YouTuber

## 💻 Desarrollo

### Requisitos
- Android Studio (versión 2024.1+)
- JDK 17+
- Gradle 8.0+

### Construir desde código fuente

```bash
# Clonar el repositorio
git clone https://github.com/lostlilbot/YoutuberHN.git

# Ir al directorio
cd youtuber_hn

# Dar permisos al gradlew
chmod +x gradlew

# Construir debug APK
./gradlew assembleDebug
```

El APK se generará en: `youtuber_hn/app/build/outputs/apk/debug/app-debug.apk`

## 📁 Estructura del Proyecto

```
youtuber_hn/
├── app/
│   └── src/main/
│       ├── java/com/youtuberhn/
│       │   ├── data/
│       │   │   └── BookContent.kt       # Contenido del libro
│       │   ├── ui/
│       │   │   ├── navigation/          # Navegación y menú
│       │   │   ├── screens/             # Pantallas de la app
│       │   │   └── theme/               # Temas y colores
│       │   ├── MainActivity.kt
│       │   └── NotificationHelper.kt
│       └── res/
│           ├── drawable/                # Imágenes y gradientes
│           ├── mipmap-*/                # Iconos de la app
│           └── values/                  # Recursos
├── build.gradle.kts
└── settings.gradle.kts
```

## 🤝 Contribuir

¡Las contribuciones son bienvenidas! Si encuentras algún error o tienes sugerencias:

1. Haz un Fork del proyecto
2. Crea una rama (`git checkout -b feature/nueva-funcionalidad`)
3. Commit tus cambios (`git commit -m 'Agregar nueva funcionalidad'`)
4. Push a la rama (`git push origin feature/nueva-funcionalidad`)
5. Abre un Pull Request

## 📄 Licencia

Este proyecto es para fines educativos. El contenido del libro está basado en "De Cero a Youtuber en Honduras".

## 🇭🇳 Hecho con ❤️ para Honduras

> "El algoritmo no premia al mejor equipo. Premia a la autenticidad."

---

⌨️ Desarrollado con Kotlin y Jetpack Compose
