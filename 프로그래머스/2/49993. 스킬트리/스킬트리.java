import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0; // count
        
        for (String skillTree : skill_trees) {
            if (isValidSkillTree(skill, skillTree)) {
                answer++;
            }
        }
        
        return answer;
    }
    
    // 선행 스킬 순서에 맞게 스킬을 배우는지 확인
    private boolean isValidSkillTree(String skill, String skillTree) {
        int skillIdx = 0;
        
        for (char c : skillTree.toCharArray()) {
            if (skill.indexOf(c) == -1) {
                // 스킬 순서에 없는 스킬은 무시
                continue;
            }
            
            if (skill.charAt(skillIdx) == c) {
                // 올바른 순서로 스킬을 배움
                skillIdx++;
            } else {
                // 잘못된 순서로 스킬을 배움
                return false;
            }
            
            if (skillIdx == skill.length()) {
                // 모든 스킬을 다 배운 경우
                break;
            }
        }
        
        return true;
    }
}

