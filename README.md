# 📌 Description
เนื่องจาก Plugin นี้เป็นการทำ Web Scraping จึงอาจจะทำให้เซิฟกระตุกหน่อยๆนะครับแหะๆ (ถ้าตั้ง Duration น้อยเกินไป)


# 😁 PlaceholderAPI
- `%stritytopdonate_player_<ตำแหน่ง>%` สำหรับดึงชื่อขึ้นมาแสดง เช่น `%stritytopdonate_player_1%`
- `%stritytopdonate_amount_<ตำแหน่ง>%` สำหรับดึงจำนวนขึ้นมาแสดง เช่น `%stritytopdonate_amount_2%`


# 📝 Configuration
```yml
# This Plugins use only Strity Web Store
# Craft by VisherRyz

# 20 tick = 1 second
duration: 1200 #เวลาสำหรับการดึงค่าขึ้นมาแสดง
topDonateURL: "https://store.<yourserverdns>/?frontend=ranking" #ลิงค์เว็บ
```

# ⌨️ Commands
- `/stritytopdonate refesh` ดึงค่าจากเว็บใหม่
- `/stritytopdonate reload` การตั้งค่า
