# 高級禮品包裝
 - 這是一個插件，允許管理員將其清單複制為禮品包並發佈到五個不同的權限組，這些權限組可以使用具有預定義權限的命令聲明這些程序包。
# 特徵
- 允許管理員使用/packgift 命令複製其庫存
- 允許管理員定義特定軟件包的到期日期和權限組
- 允許管理員發布他們的禮物包
- 允許玩家領取禮物包
# 編碼風格
- 此插件沒有預定義的編碼樣式
# 使用的API /框架
- Paper引擎
# 命令
- /gift
  - 允許玩家領取禮物
- /packgift <以小時為單位的到期時間> <權限組（level1，level2, level3, level4，level5)>
  - 允許管理員根據其庫存數據創建禮物包裝，並定義到期日期和權限組
# 安裝
- 本安裝指南僅適用於Debian Linux，Windows請從 https://https://github.com/2B2TMCBE/premium-gift-package/releases 下載最新的jar文件，然後繼續執行步驟7。

1.要求安裝紙釘。
2.使用以下命令下載maven：
```sudo apt-get install maven```
3.安裝後，運行以下命令來克隆此git存儲庫：
```git clone https：//github.com/2B2TMCBE/premium-gift-package.git```
4.將目錄更改為插件的基本目錄，該目錄包含名為pom.xml的文件
5.運行此命令以使用maven編譯插件
```mvn clean package```
6.等到編譯過程完成後，現在應該創建一個名為“target”的新目錄，進入目錄。
7.將名為“ premium_gift-1.0-SNAPSHOT-shaded.jar”的jar文件移至Paper的服務器目錄，並將其移至名為plugins的目錄。
8.重新啟動服務器，應安裝插件。
# 貢獻
-這個項目是開放的，可以拉取請求，每個人都可以使用，分叉，私有化或修改此插件
# 執照
MIT許可證
