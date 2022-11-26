#!/usr/bin/sh
doc="doc"
pandoc -o $doc.html -f markdown-auto_identifiers -t html $doc.md &&
pandoc -o $doc.docx -f html -t docx $doc.html &&
rm -rf doc.html