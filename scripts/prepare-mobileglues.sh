#!/usr/bin/env bash
set -euo pipefail
ROOT="$(cd "$(dirname "$0")/.." && pwd)"
DEST="$ROOT/third_party/MobileGlues"
COMMIT="97558a69157b033b890958b1e49258c5b51a80c6"

if [ ! -d "$DEST/.git" ]; then
  git clone --recurse-submodules https://github.com/MobileGL-Dev/MobileGlues.git "$DEST"
fi
git -C "$DEST" fetch origin "$COMMIT"
git -C "$DEST" checkout "$COMMIT"
git -C "$DEST" submodule update --init --recursive
echo "MobileGlues pinned at $COMMIT"
