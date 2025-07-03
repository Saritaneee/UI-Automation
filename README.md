# UI-Automation
# UI Test Automation Project - SauceDemo.com

Ini adalah proyek pengujian otomatis berbasis UI untuk situs SauceDemo.com menggunakan Java, Cucumber (BDD), Selenium WebDriver, dan Gradle.

Pengujian ini mencakup login, fitur keranjang (cart), dan proses checkout, termasuk skenario positif, negatif, dan batas (boundary).

## Tujuan Proyek

- Menerapkan pengujian UI otomatis dengan pendekatan Behavior-Driven Development (BDD)
- Menguji fitur utama seperti login, menambahkan dan menghapus item dari keranjang, dan checkout
- Menggunakan pola Page Object Model untuk pemisahan antara logika halaman dan pengujian
- Menyediakan struktur pengujian yang fleksibel dan dapat dikembangkan lebih lanjut

## Tools dan Teknologi

- Java 17–23
- Gradle
- Selenium WebDriver
- Cucumber
- JUnit

## Struktur Proyek

```
cucumberPraktik/
├── build.gradle
├── gradle/
├── gradlew
├── gradlew.bat
├── README.md
├── reports/
├── settings.gradle
└── src/
    └── test/
        └── java/
            └── com/
                └── tane/
                    ├── BaseTest.java
                    ├── CucumberTest.java
                    ├── page/
                    │   ├── CartPage.java
                    │   ├── CheckoutPage.java
                    │   ├── HomePage.java
                    │   └── LoginPage.java
                    └── stepDef/
                        ├── CartStepDef.java
                        ├── CheckoutStepDef.java
                        ├── CucumberHooks.java
                        ├── HomeStepDef.java
                        └── LoginStepDef.java
        └── resources/
            ├── cart.feature
            ├── checkout.feature
            └── login.feature

```

## Fitur yang Diuji

| Fitur      | Jenis Tes     | Tag         |
|------------|---------------|-------------|
| Login      | Positif       | @positive   |
|            | Negatif       | @negative   |
|            | Boundary      | @boundary   |
| Cart       | Tambah/Hapus  | @cart       |
| Checkout   | Valid dan error input | @positive, @negative, @boundary |

## Menjalankan Pengujian

### Persiapan

Pastikan sudah terpasang:

- Java JDK 17–21
- Gradle
- Browser Chrome

### Clone Repositori

```

cd ui-saucedemo-testing
```

### Install dependensi dan build

```
./gradlew clean build
```

### Jalankan semua tes

```
./gradlew test
```

### Lihat laporan hasil pengujian

Buka file berikut:

```
build/reports/tests/test/index.html
```

## Menjalankan Berdasarkan Tag

Jalankan tes login saja:

```
./gradlew test --tests * --info -Dcucumber.filter.tags="@login"
```

Jalankan tes boundary saja:

```
./gradlew test --tests * --info -Dcucumber.filter.tags="@boundary"
```

## Konfigurasi Gradle

Contoh dependensi di build.gradle:

```
dependencies {
    testImplementation 'io.cucumber:cucumber-java:7.11.2'
    testImplementation 'io.cucumber:cucumber-junit:7.11.2'
    testImplementation 'org.seleniumhq.selenium:selenium-java:4.11.0'
    testImplementation 'junit:junit:4.13.2'
}
```

## Catatan

- Diuji pada Chrome
- Gunakan Java 17–21 untuk kompatibilitas Gradle yang stabil
