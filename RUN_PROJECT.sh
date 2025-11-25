#!/bin/bash

# ============================================
# Electricity Billing System - Run Script
# ============================================

PROJECT_DIR="/home/mostafa/Desktop/monstfa_cv/marwa"
cd "$PROJECT_DIR"

echo "======================================"
echo "  Electricity Billing System"
echo "======================================"
echo ""

# 1. Check Java installation
echo "📌 Checking Java installation..."
if ! command -v java &> /dev/null; then
    echo "❌ Java is not installed!"
    echo "Please install Java 8 or higher"
    exit 1
fi

JAVA_VERSION=$(java -version 2>&1 | head -n 1)
echo "✅ Java found: $JAVA_VERSION"
echo ""

# 2. Create bin directory if not exists
if [ ! -d "bin" ]; then
    echo "📁 Creating bin directory..."
    mkdir -p bin
fi

# 3. Compile the project
echo "🔨 Compiling project..."
find src -name "*.java" > sources.txt
javac -d bin -encoding UTF-8 @sources.txt 2>&1

if [ $? -eq 0 ]; then
    echo "✅ Compilation successful!"
    rm sources.txt
    echo ""
else
    echo "❌ Compilation failed!"
    rm sources.txt
    exit 1
fi

# 4. Run the application
echo "🚀 Starting application..."
echo "======================================"
echo ""
java -cp bin com.electricity.Main

echo ""
echo "======================================"
echo "Application closed"
echo "======================================"
