# 🌱 Agrix - إدارة ومراقبة المزارع

![الحالة: قيد التطوير](https://img.shields.io/badge/status-in%20development-yellow)

<h2>🌐</h2>
<ul>
  <li><a href="https://github.com/SamuelRocha91/Agrix" target="_blank">Português</a></li>
  <li><a href="https://github.com/SamuelRocha91/Agrix/blob/main/README_es.md" target="_blank">Español</a></li>
  <li><a href="https://github.com/SamuelRocha91/Agrix/blob/main/README_en.md" target="_blank">English</a></li>
  <li><a href="https://github.com/SamuelRocha91/Agrix/blob/main/README_ru.md" target="_blank">Русский</a></li>
  <li><a href="https://github.com/SamuelRocha91/Agrix/blob/main/README_ch.md" target="_blank">中文</a></li>
  <li><a href="https://github.com/SamuelRocha91/Agrix/blob/main/README_ar.md" target="_blank">العربية</a></li>
</ul>

## 📜 مقدمة

مشروع Agrix هو مشروع تقييم تم تطويره في وحدة Java من دورة تطوير الويب في Trybe. استخدم المشروع Java و Maven و Docker و MySQL وأغلب نظام Spring البيئي. تم بناء التطبيق بحرية كاملة من حيث التنفيذ، بدءاً من معالجة الشيفرة وحتى الإعداد.

الهدف من التطبيق هو إدارة ومراقبة المزارع المشاركة التي تسعى لتحسين تقنياتها واستخدام الأراضي بشكل مسؤول. يشمل النظام مسارات للتوثيق والتفويض وتسجيل المزارع والمحاصيل والأسمدة والمزيد.

## 🛠️ الميزات المنفذة

- **التوثيق والتفويض**: تنفيذ الأمان باستخدام Spring Security لإدارة الوصول إلى مسارات التطبيق.
- **تسجيل الكيانات**: مسارات لتسجيل المزارع والمحاصيل والأسمدة.
- **إدارة المخزون والمحاصيل**: وظائف لإدارة مخزون الأسمدة والمحاصيل في المزارع.
- **API REST**: تطوير واجهة برمجة التطبيقات REST للتفاعل مع النظام.
- **إدارة الأخطاء**: تنفيذ إدارة الأخطاء باستخدام Spring Web.
- **Docker**: إنشاء Dockerfile لتكوين التطبيق لتشغيله على Docker.

## 📚 المهارات المطورة

خلال تطوير هذا المشروع، تم العمل على تطوير المهارات التالية:

- **Spring Framework**: استخدام Spring لبناء التطبيق وتنفيذ الأمان.
- **Spring Security**: تطبيق المعرفة لإضافة التوثيق والتفويض.
- **Java Web**: تطوير تطبيق ويب باستخدام Java.
- **REST API**: إنشاء مسارات API وتنفيذها باستخدام Spring.
- **Spring Data JPA**: استخدامه لتخزين البيانات في قاعدة البيانات.
- **Docker**: تكوين التطبيق ليعمل في حاويات Docker.
- **JUnit**: تنفيذ الاختبارات باستخدام إطار JUnit.

## 📋 المتطلبات

- **Java 17**
- **Maven 3.8.1 أو أعلى**
- **Docker** (اختياري، لتشغيله في الحاويات)

## 🔧 التثبيت والتشغيل

اتبع الخطوات أدناه لتكوين وتشغيل المشروع محليًا:

### 1. استنساخ المستودع

```bash
git clone https://github.com/your-username/agrix.git
```

### 2. انتقل إلى دليل المشروع

```bash
cd agrix
```

### 3. قم بترجمة وتشغيل التطبيق

لتجميع وتشغيل التطبيق محليًا، استخدم Maven:

```bash
mvn spring-boot:run
```

### 4. قم بتشغيل الاختبارات

لتشغيل الاختبارات التلقائية، استخدم الأمر التالي:

```bash
mvn test
```

### 5. تكوين Docker

لبناء وتشغيل التطبيق باستخدام Docker، اتبع الخطوات التالية:

1. بناء صورة Docker:

   ```bash
   docker build -t agrix .
   ```

2. تشغيل حاوية Docker:

   ```bash
   docker run -p 8080:8080 agrix
   ```

## 🗂️ هيكل الملفات

هيكل المشروع منظم على النحو التالي:

```
.
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── betrybe/
│   │   │           └── agrix/
│   │   │               ├── controller/        # Controllers للـ API
│   │   │               ├── model/             # نماذج البيانات
│   │   │               ├── repository/        # مستودعات JPA
│   │   │               ├── service/           # خدمات التطبيق
│   │   │               └── AgrixApplication.java  # الفئة الرئيسية
│   ├── test/
│   │   └── java/
│   │       └── com/
│   │           └── betrybe/
│   │               └── agrix/
│   │                   ├── controller/        # اختبارات Controllers
│   │                   ├── service/           # اختبارات الخدمات
│   │                   └── repository/        # اختبارات المستودعات
├── Dockerfile                # Dockerfile لتكوين التطبيق
├── pom.xml                   # ملف تكوين Maven
└── README.md                 # وثائق المشروع
```

## 📦 الاعتماديات

الاعتماديات الرئيسية للمشروع هي:

- [Spring Boot](https://spring.io/projects/spring-boot): إطار عمل لتطوير تطبيقات Java.
- [Spring Security](https://spring.io/projects/spring-security): إطار عمل للأمان والتوثيق.
- [Java JWT](https://github.com/auth0/java-jwt): مكتبة لمعالجة JWT.
- [MySQL Connector/J](https://dev.mysql.com/downloads/connector/j/): موصل JDBC لـ MySQL.
- [JUnit](https://junit.org/junit5/): إطار عمل للاختبارات الوحدوية.

## 🚀 التحسينات المستقبلية

المشروع قيد التطوير، ومن المخطط تنفيذ التحسينات التالية:

- **إعادة هيكلة الطبقات**: تحسين الفصل بين طبقات التحكم والخدمات والاحتفاظ.
- **تحسين Docker**: تعديل تكوين Docker لتحسين بناء وتشغيل التطبيق.
- **الاختبارات التلقائية**: توسيع نطاق تغطية الاختبارات التلقائية لضمان قوة التطبيق.
