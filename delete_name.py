#!/usr/bin/env python3
# -*- coding: utf-8 -*-

import os
import sys

def process_file(filepath):
    """
    处理单个Java文件：如果文件中的package或import行包含"main.java."，则移除该子串。
    """
    with open(filepath, 'r', encoding='utf-8') as f:
        lines = f.readlines()

    modified = False
    new_lines = []

    for line in lines:
        stripped = line.lstrip()
        # 只处理以package或import开头的行
        if stripped.startswith(('package ', 'import ')):
            new_line = line.replace('main.java.', '')
            if new_line != line:
                modified = True
            new_lines.append(new_line)
        else:
            new_lines.append(line)

    if modified:
        with open(filepath, 'w', encoding='utf-8') as f:
            f.writelines(new_lines)
        print(f'✅ 已修改: {filepath}')
    else:
        print(f'⏭️  无需修改: {filepath}')

def main():
    # 默认从当前工作目录查找 src/main/java
    base_dir = os.path.join(os.getcwd(), 'src', 'main', 'java')
    if not os.path.isdir(base_dir):
        print(f'❌ 错误: 目录 "{base_dir}" 不存在，请确保在Maven项目根目录下运行此脚本。', file=sys.stderr)
        sys.exit(1)

    print(f'🔍 开始处理目录: {base_dir}')
    for root, _, files in os.walk(base_dir):
        for filename in files:
            if filename.endswith('.java'):
                filepath = os.path.join(root, filename)
                process_file(filepath)

    print('✅ 所有文件处理完成。')

if __name__ == '__main__':
    main()