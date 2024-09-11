#!/bin/bash

# Mensaje predefinido para el commit
PREDEFINED_MESSAGE="Commit automático: "

# Obtener la fecha actual
DATE=$(date '+%Y-%m-%d')

# Combinar el mensaje con la fecha
COMMIT_MESSAGE="$PREDEFINED_MESSAGE $DATE"

# Añadir los archivos al área de preparación (staging)
git add .

# Hacer el commit con el mensaje predefinido y la fecha
git commit -m "$COMMIT_MESSAGE"

git push