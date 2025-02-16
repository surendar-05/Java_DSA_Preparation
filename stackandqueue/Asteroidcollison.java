class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < asteroids.length; i++) {

            if (asteroids[i] > 0) {
                list.add(asteroids[i]);
            } else {
                // Remove smaller positive asteroids that collide with current negative one
                while (list.size() != 0 && list.get(list.size() - 1) > 0 && list.get(list.size() - 1) < Math.abs(asteroids[i])) {
                    list.remove(list.size() - 1);
                }

                // If last asteroid is equal in magnitude, remove it (both destroy each other)
                if (!list.isEmpty() && list.get(list.size() - 1) == Math.abs(asteroids[i])) {
                    list.remove(list.size() - 1);
                } else if (list.size() == 0 || list.get(list.size() - 1) < 0) {
                    list.add(asteroids[i]);
                }
            }
        }

        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }

        // Return the final state of asteroids
        return result;
    }
}
