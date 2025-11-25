# Electricity Billing System ⚡

A comprehensive desktop application for managing electricity billing operations built with Java Swing.

## Project Structure

```
ElectricityBillingSystem/
├── src/
│   └── com/
│       └── electricity/
│           ├── models/           # Data Models (Entities)
│           │   ├── users/        # User-related models
│           │   │   ├── User.java (Abstract base class)
│           │   │   ├── Customer.java
│           │   │   ├── Operator.java
│           │   │   ├── Admin.java
│           │   │   ├── UserRole.java
│           │   │   ├── UserStatus.java
│           │   │   └── CustomerType.java
│           │   ├── billing/      # Billing-related models
│           │   │   ├── Bill.java
│           │   │   ├── BillStatus.java
│           │   │   ├── Reading.java
│           │   │   ├── ReadingStatus.java
│           │   │   ├── Payment.java
│           │   │   ├── PaymentMethod.java
│           │   │   └── PaymentStatus.java
│           │   └── system/       # System models
│           │       ├── Complaint.java
│           │       └── Meter.java
│           ├── ui/               # User Interface Layer
│           │   ├── auth/         # Authentication screens
│           │   │   ├── LoginFrame.java
│           │   │   └── RegisterFrame.java
│           │   ├── customer/     # Customer module UI
│           │   │   ├── CustomerDashboardFrame.java
│           │   │   ├── EnterReadingPanel.java
│           │   │   ├── ViewBillsPanel.java
│           │   │   ├── PayBillPanel.java
│           │   │   └── ComplaintsPanel.java
│           │   ├── operator/     # Operator module UI
│           │   │   ├── OperatorDashboardFrame.java
│           │   │   ├── ReviewReadingsPanel.java
│           │   │   └── CollectPaymentPanel.java
│           │   └── admin/        # Admin module UI
│           │       ├── AdminDashboardFrame.java
│           │       ├── ApproveCustomersPanel.java
│           │       ├── ManageUsersPanel.java
│           │       └── ReportsPanel.java
│           └── Main.java         # Application entry point
├── lib/                          # External libraries (if needed)
└── README.md                     # This file
```

## OOP Principles Implemented

### 1. Encapsulation (التغليف)
- All model classes have private fields with public getters/setters
- Data is protected and accessed through controlled methods
- Example: `Bill.java` class with private fields and public methods

### 2. Inheritance (الوراثة)
- `User` is an abstract base class
- `Customer`, `Operator`, and `Admin` extend `User`
- Common properties inherited, specific properties added in subclasses

### 3. Polymorphism (تعدد الأشكال)
- Abstract methods in `User` class: `displayDashboard()`, `getUserTypeDescription()`
- Each subclass implements these methods differently
- Same method name, different implementation for each user type

### 4. Abstraction (التجريد)
- `User` class is abstract - cannot be instantiated directly
- Forces subclasses to implement required methods
- Hides complex implementation details

## Features by Module

### 1. Old Customer Module
- ✅ Pay bills with meter code
- ✅ Enter monthly meter reading
- ✅ View bill history
- ✅ Submit complaints about bills
- ✅ View complaint status

### 2. New Customer Module
- ✅ Fill registration information
- ✅ Upload contract document (apartment/ownership)
- ✅ Wait for admin approval
- ✅ Receive email notification when approved

### 3. Operator Module
- ✅ Review and approve/reject customer readings
- ✅ Collect cash payments from customers
- ✅ Print bills for customers
- ✅ View bills in specific region
- ✅ Validate readings against consumption patterns
- ✅ Define tariff rates for region
- ✅ Stop meter and cancel subscriptions

### 4. Admin Module
- ✅ View all bills across all regions
- ✅ View total revenue collected
- ✅ Generate consumption statistics by region
- ✅ Add/update/delete users with different roles
- ✅ Approve new customer requests
- ✅ Manage complaints
- ✅ Generate reports (PDF/Excel)

## How to Run

### Prerequisites
- Java Development Kit (JDK) 8 or higher
- Java IDE (IntelliJ IDEA, Eclipse, or NetBeans) - Optional

### Compilation and Execution

#### Option 1: Using Command Line

1. Navigate to the project directory:
```bash
cd /home/mostafa/Desktop/monstfa_cv/marwa
```

2. Compile the Java files:
```bash
javac -d bin -sourcepath src src/com/electricity/Main.java src/com/electricity/**/*.java
```

3. Run the application:
```bash
java -cp bin com.electricity.Main
```

#### Option 2: Using an IDE

1. Open your Java IDE (IntelliJ IDEA, Eclipse, NetBeans)
2. Import the project as a Java project
3. Set `src` as the source folder
4. Run `Main.java` class
5. The login screen will appear

### Default Login Credentials (For Testing)

Since this is UI only with no logic, you'll need to implement authentication logic.
Sample credentials structure:

**Old Customer:**
- Username: `customer1`
- Password: `customer123`
- Meter Code: `123456`

**Operator:**
- Username: `operator1`
- Password: `operator123`
- Region: `Cairo - Nasr City`

**Administrator:**
- Username: `admin`
- Password: `admin123`

## Implementation Notes

### Current Status
✅ **Completed:**
- Complete project structure following best practices
- All model classes with OOP principles
- All UI screens for all modules (Customer, Operator, Admin)
- Professional and organized codebase
- Clean separation of concerns

⏳ **Pending (Your Task):**
- Business logic implementation
- Database integration (MySQL, SQLite, or file-based)
- Email notification system
- Report generation (PDF/Excel export)
- Input validation
- Error handling
- Data persistence

### Next Steps for Implementation

1. **Database Design:**
   - Create database schema for users, bills, readings, payments, complaints, meters
   - Implement DAO (Data Access Objects) for CRUD operations

2. **Business Logic:**
   - Implement authentication and authorization
   - Add reading validation logic
   - Implement bill calculation
   - Add payment processing
   - Implement email notifications

3. **Connect UI to Logic:**
   - Add event listeners to buttons
   - Implement form validation
   - Connect UI components to business logic
   - Add data binding

4. **Testing:**
   - Unit tests for business logic
   - Integration tests for UI flows
   - End-to-end testing

## Technologies Used

- **Language:** Java 8+
- **UI Framework:** Java Swing
- **Architecture:** MVC-inspired (Models, Views separated)
- **Design Patterns:**
  - Singleton (for database connections)
  - Factory (for user creation)
  - Observer (for event handling)

## System Requirements

- **OS:** Windows, macOS, or Linux
- **Memory:** Minimum 512 MB RAM
- **Storage:** 100 MB free space
- **Display:** 1024x768 minimum resolution

## Contributing

This is an educational project. To extend or improve:

1. Fork the repository
2. Create a feature branch
3. Implement your changes
4. Test thoroughly
5. Submit a pull request

## License

This project is created for educational purposes.

## Contact

For questions or support regarding this project, please contact the development team.

---

**Note:** This project contains UI implementations only. Business logic, database integration, and other backend functionalities need to be implemented according to your requirements.
