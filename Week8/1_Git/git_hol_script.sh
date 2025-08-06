#!/bin/bash

# Step 1: Git configuration
git config --global user.name "Your Name"
git config --global user.email "your.email@example.com"

# Step 2: Set default editor to Notepad++
git config --global core.editor "notepad++.exe"

# Step 3: Initialize Git repository and add a file
mkdir GitDemo
cd GitDemo
git init
echo "Welcome to Git Hands-on Lab" > welcome.txt
git status
git add welcome.txt
git commit -m "Initial commit - Added welcome.txt"
