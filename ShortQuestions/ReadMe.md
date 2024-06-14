# Short Questoins
## Homeworks
### HW1
## SandBox Area
### Styling text
Hello world\
**Hello world**\
*Hello world*\
~~Hello world~~\
**He_llo wor_ld**\
***Hello world***\
He<sub>llo wor</sub>ld**\
He<sup>llo wor</sup>ld**
### Quoting text
Hello world\
>Hello world
### Quoting code
```
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){

            if(map.get(target-nums[i]) != null){
                return new int[] {i,map.get(target-nums[i])};
            }

            map.put(nums[i],i);
        }

        return null;
    }
```
### Links
This is [GitHub](https://pages.github.com/).
### Section Link
This is [HW1](HW1.md)
### Images
![a ramen brand](https://en.wikipedia.org/wiki/Ichiran#/media/File:Ichiran_logo.png).




