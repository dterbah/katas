package com.terbah;

import java.util.ArrayList;
import java.util.List;

public class Snail {

    private SnailDirection direction;

    private Position position;

    private final List<Position> visitedCells;

    public Snail() {
        this.visitedCells = new ArrayList<>();
        this.direction = SnailDirection.RIGHT;
        this.position = new Position(0, 0);
    }

    private enum SnailDirection {
        TOP,
        RIGHT,
        BOTTOM,
        LEFT
    }

    private record Position(int x, int y) {}

    private int nextMove(int[][] grid) {
        var value = grid[position.y][position.x];
        Position nextOne = nextPosition();
        if (isOutOfBounds(grid, nextOne)) {
            direction = nextDirection();
        }

        visitedCells.add(new Position(position.x, position.y));
        position = nextPosition();
        return value;
    }

    private Position nextPosition() {
        return switch (direction) {
            case RIGHT -> new Position(position.x + 1, position.y);
            case LEFT -> new Position(position.x - 1, position.y);
            case TOP -> new Position(position.x, position.y - 1);
            case BOTTOM -> new Position(position.x, position.y + 1);
        };
    }

    private SnailDirection nextDirection() {
        return switch (direction) {
            case BOTTOM -> SnailDirection.LEFT;
            case LEFT -> SnailDirection.TOP;
            case TOP -> SnailDirection.RIGHT;
            case RIGHT -> SnailDirection.BOTTOM;
        };
    }

    private boolean isOutOfBounds(int[][] grid, Position position) {
        if (position.x >= grid.length || position.x < 0) return true;
        if (position.y >= grid.length || position.y < 0) return true;

        return this.visitedCells.contains(position);
    }

    private int[] snailIt(int[][] array) {
        if (array.length == 0 || array[0].length == 0) return new int[0];
        var s = new Snail();
        int n = array.length;
        int[] path = new int[n * n];

        int i = 0;
        for (var y = 0; y < n; y++) {
            for (var x = 0; x < n; x++) {
                path[i++] = s.nextMove(array);
            }
        }

        return path;
    }

    public static int[] snail(int[][] array) {
        return new Snail().snailIt(array);
    }
}
