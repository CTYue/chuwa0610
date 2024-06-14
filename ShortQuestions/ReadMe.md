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
![RandomImg](https://farm8.staticflickr.com/7377/9359257263_81b080a039_z_d.jpg)
### Lists
- a list
* a list 
+ a list 
1. list1
2. list2
3. list3
4. nest
	- 1 level
		-2 level
### Task Lists
- [ ] not done
- [x] done
### Mentioning
@github/support What do you think about these updates?
### Susing emojis
:smiley::blush::metal:

:smiley::blush::metal:
### Footnotes
1+1=?[^1]\
2+2=?[^2]
[^1]: 2
[^2]: 4
### Alerts
> [!NOTE]
> Hello world

> [!TIP]
> Hello world

> [!IMPORTANT]
> Hello world

> [!WARNING]
> Hello world

> [!CAUTION]
> Hello world

### Hidden content
<!-- This content will not appear in the rendered Markdown -->
### Ignore format
What is \*a-b-b-a\*  
