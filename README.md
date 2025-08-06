# Static Factory Game

A survival-style Java game where the player explores alien moons, collects scrap, interacts with mysterious terminals, and makes strategic decisions to survive — or profit.

This project focuses on **clean object-oriented design**, modular code structure, and extendability — featuring mechanics like teleportation, item trading, and reactive NPCs.
Read docs to explore more on technical stuff.
---

## 🚀 Features

### 🔁 Teleportation System
- **THESEUS** teleporters allow the player to randomly warp within a map.
- Players can drop, activate, and use teleporters freely — but the destination is always unpredictable.
- Designed using clear action/command abstraction for easy extension.

### 🏭 Scrap Selling: The Static Factory
- Interact with a humanoid robot to sell collected items.
- Each item has **custom trade logic**:
  - 🔩 Large bolts: always 25 credits
  - 🧻 Toilet paper rolls: 50% chance of instant death
  - 🥒 Pickles: 50% chance of getting double payout
  - 🛢️ Pots of gold: 25% chance of being stolen
- Fully decoupled item pricing and randomness logic.

### 🧠 AI Monologue Device (Astley)
- Buyable AI companion that talks to the player.
- Dialogue adapts to player state (credits, inventory size, health).
- Requires an ongoing **subscription fee** (1 credit every 5 ticks).
- Shows how abstraction and strategy patterns were applied.

### 🌕 Multiple Maps
- Travel across multiple moons via computer terminals
- Each map is self-contained and extendable (e.g. new moon layouts)

---

## 🧱 Design Principles

This project emphasizes:
- ✅ **SOLID principles** (especially Open/Closed and Single Responsibility)
- ✅ Clear separation between **behaviours**, **actions**, and **entities**
- ✅ Flexible command patterns for in-game interactions
- ✅ Use of randomness abstracted behind service classes

---

## 🛠 Tech Stack

- 💻 **Java** (OOP design, polymorphism, interfaces)
- 🧰 IntelliJ IDEA
- 📂 Version control via Git

---

## 🤔 Why This Project?

A fun way to demonstrate:
- Object-oriented game mechanics
- Domain-specific interaction logic (e.g. market prices, map transitions)
- How to design for future extensibility (e.g. adding new AI types, factory rules, map types)

---

## 🧪 How to Run

1. Clone the repo
2. Open in IntelliJ or your Java IDE of choice
3. Run the main game engine (you’ll be dropped into the game world!)
4. Try collecting items, talking to the robot, and using the teleporters...

---

## 📌 Future Ideas

- Add teleport cooldown or durability
- AI device with learning or memory
- Expand factory with a black market for rare items
- Visual UI integration

---

## 📄 License

This project is open for learning and personal use. Feedback welcome!

