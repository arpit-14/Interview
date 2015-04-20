/* https://leetcode.com/problems/compare-version-numbers/
 * https://leetcode.com/submissions/detail/25430471/
 * 
 * Compare two version numbers version1 and version2.
If version1 > version2 return 1, if version1 < version2 return -1, otherwise return 0.

You may assume that the version strings are non-empty and contain only digits and the . character.
The . character does not represent a decimal point and is used to separate number sequences.
For instance, 2.5 is not "two and a half" or "half way to version three", it is the fifth second-level revision of the second first-level revision.

Here is an example of version numbers ordering:

0.1 < 1.1 < 1.2 < 13.37
 *
 * */

package com.arpit.leetcode;

public class CompareVersionNumbers {

    public int compareVersion(String v1, String v2) {
        
        if(v1.equals(v2)){
            return 0;
        }
        
        String[] ver1 = v1.split("\\.");
        String[] ver2 = v2.split("\\.");
        
        int l1 = ver1.length;
        int l2 = ver2.length;
        
        for(int i=0; i<l1 && i<l2; i++){
            
            int n1 = Integer.parseInt(ver1[i]);
            int n2 = Integer.parseInt(ver2[i]);
            
            if(n1<n2){
                return -1;
            }else if(n1>n2){
                return 1;
            }
            
        }

        if(l1<l2){
            for(int i=l1; i<l2; i++){
                int n1 = Integer.parseInt(ver2[i]);
                if(n1>0){
                    return -1;
                }
            }
            return 0;
        }else if(l1>l2){
            for(int i=l2; i<l1; i++){
                int n1 = Integer.parseInt(ver1[i]);
                if(n1>0){
                    return 1;
                }
            }
            return 0;
        }
        
        return 0;
    }
    
}