import os
import re

def rename_class_to_match_filename(directory):
    """
    주어진 디렉토리와 하위 디렉토리 내 모든 .java 파일의 클래스명을 파일명과 동일하게 변경
    """
    for root, dirs, files in os.walk(directory):  # 하위 디렉토리까지 탐색
        for filename in files:
            if filename.endswith(".java"):
                filepath = os.path.join(root, filename)
                class_name = filename[:-5]  # 파일명에서 .java 제거

                with open(filepath, "r", encoding="utf-8") as file:
                    content = file.read()

                # 기존 클래스명 찾기 및 새로운 클래스명으로 변경
                updated_content = re.sub(
                    r"\bclass\s+\w+",
                    f"class {class_name}",
                    content,
                    count=1  # 첫 번째 매칭만 변경
                )

                with open(filepath, "w", encoding="utf-8") as file:
                    file.write(updated_content)

                print(f"Updated class in {filepath} to {class_name}")

# 사용자가 자바 파일을 저장한 상위 디렉토리 경로를 입력
directory_path = "/Users/kyulilee/Documents/Algorithm"
rename_class_to_match_filename(directory_path)

