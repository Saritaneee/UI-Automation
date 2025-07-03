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

- Java 17–23 (disarankan: Java 17 atau 21)
- Gradle
- Selenium WebDriver
- Cucumber
- JUnit

## Struktur Proyek

```
ui-saucedemo-testing/
├── build.gradle
├── settings.gradle
├── README.md
├── src/
│   ├── main/java/pages/
│   └── test/
│       ├── java/
│       │   ├── stepdefinitions/
│       │   └── runners/
│       └── resources/features/
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
