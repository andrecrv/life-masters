# ✨ SCSS Pocket Guide  

A compact reference for writing clean, maintainable, and scalable SCSS. Follow these conventions and structural tips to keep your styles modular and easy to manage across small and large projects alike.  

## 📁 Structure Overview  

Organise your SCSS files into purposeful folders to improve clarity and scalability. Each folder handles a distinct responsibility.

```
scss/
│
├── base/        # Reset, typography, base styles
├── components/  # Buttons, cards, navbar, etc.
├── layout/      # Grid, header, footer, etc.
├── utils/       # Variables, mixins, functions
└── main.scss    # Entry point that imports all
```

> 🔹 Keep partials small and specific.  
> 🔹 Prefix filenames with `_` (e.g. `_buttons.scss`) to indicate they are partials.

## 🧱 Class Naming (BEM)

The **BEM methodology** (Block Element Modifier) helps you write semantic, modular, and reusable CSS classes. It’s ideal for SCSS structure and nesting.  

```
.block { }
.block__element { }
.block--modifier { }
```

### ✅ Example:

```scss
.card {
  &__title {
    font-size: 1.2rem;
  }

  &--highlighted {
    background: $highlight-color;
  }
}
```  

> 🔹 Use `&` for nesting under the block.  
> 🔹 Avoid deep nesting—keep it flat and readable.

## 🎯 SCSS Best Practices

Follow these core rules to keep your SCSS clean and consistent:

- ✅ Keep **nesting shallow** (2–3 levels max)
- ✅ Use **variables** for common values (colours, spacing, etc.)
- ✅ Break code into **partials** and import them in a main file
- ✅ Prefer **mixins** and functions over `@extend`
- ✅ Use **descriptive comments** to label sections and rules
- ✅ Write **mobile-first** styles (start with base, then use `min-width` media queries)

> ✨ Tip: SCSS is powerful, but with great power comes great need for structure.  

## 🌍 Global vs Modular Styles  

Use global styles for resets, layout, and shared utilities. Use modular styles (often scoped to components) to avoid conflicts and improve maintainability.  

| Type        | Use For                             | Stored In                |
|-------------|--------------------------------------|---------------------------|
| **Global**  | Reset, base layout, shared classes   | `base/`, `layout/`, `utils/` |
| **Modular** | Component-specific styles            | `components/` or `.module.scss` |

> 🔹 Global = reusable foundation  
> 🔹 Modular = isolated, component-safe styles  

## 💡 Formatting Conventions  

Consistent formatting keeps your styles readable.

- 📄 **Filenames**: `kebab-case` -> `_button-group.scss`
- 💲 **Variables**: `$camelCase` or `$kebab-case` -> `$primary-color`
- 📏 **Spacing**: Use consistent **2 or 4 spaces** for indentation
- 📐 **Line breaks**: Leave a blank line between blocks or sections

```scss
// Good
$primary-color: #0057ff;

.button {
  padding: 1rem;
  color: $primary-color;
}
```

## 🚀 TL;DR  

> Use BEM naming, keep nesting shallow, structure with partials, separate global from modular styles, follow consistent formatting, and comment your code for clarity.  

## 🧩 Sample `main.scss`

Your SCSS entry point should import your project structure cleanly and logically:

```scss
// Utilities
@import 'utils/variables';
@import 'utils/mixins';

// Base styles
@import 'base/reset';
@import 'base/typography';

// Layout
@import 'layout/grid';
@import 'layout/header';
@import 'layout/footer';

// Components
@import 'components/button';
@import 'components/card';
@import 'components/modal';
```  

> 🔹 Avoid writing styles directly in `main.scss` — only imports.  
