#!/bin/bash

# Initialize a new Git repository
git init

# Create a sample .log file and a log directory with a file
echo "This is a log file" > debug.log
mkdir log
echo "Log content" > log/sample.log

# Create a .gitignore file
echo "*.log" > .gitignore
echo "log/" >> .gitignore

# Add and commit .gitignore (log files/folders will be ignored)
git add .gitignore
git commit -m "Add .gitignore to ignore .log files and log folder"

# Show status to confirm ignored files
git status
