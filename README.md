# 🚀 Swag Labs Appium Automation
---

### 🧪 Overview
Automated **mobile testing** of the Swag Labs Android app using **Appium + Java + TestNG**.  
The test automatically boots an Android Emulator, installs the app, performs a **login**, and verifies that the **Products** screen is displayed.

---

### ⚙️ Tech Stack
| Component | Version / Tool |
|------------|----------------|
| **Language** | Java 21 |
| **Build Tool** | Maven 3.9.9 |
| **Frameworks** | Appium 3.1.0 · TestNG |
| **Device** | Android Emulator (`Pixel_6_API_33`) |
| **Automation Engine** | UiAutomator2 |

---

### 📲 What It Does
- Boots the Android emulator automatically  
- Installs and launches the Swag Labs sample app  
- Inputs username/password (`standard_user` / `secret_sauce`)  
- Clicks **LOGIN**  
- Asserts that the **PRODUCTS** screen is visible ✅  

---

### 🧰 Setup
```bash
# Install Appium & driver
npm install -g appium
appium driver install uiautomator2

# Start Appium server
appium

# Run tests
mvn test
