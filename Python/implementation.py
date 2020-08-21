"""
Wyatt Cupp
wyattcupp@gmail.com
"""


def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
	""" 
	#49 Group Anagrams - MEDIUM
	https://leetcode.com/problems/group-anagrams/
	Approx. O(n log(k)) where n is length of array and k is length of each string
	"""
	if strs.length == 0: return []

	results = [[]]
	_map = {}
	for s in strs:
		sorted_str = sort(s)

		if sorted_str not in _map:
			_map[sorted_str] = [s]
			continue
		_map[sorted_str] = 

